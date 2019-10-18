package service.processor;

import io.vertx.core.Future;
import model.events.Context;
import service.handlers.EventHandler;

import java.util.List;
import java.util.Optional;

public class RecursiveEventProcessor implements EventProcessor {
    private List<EventHandler> eventHandlers;

    public RecursiveEventProcessor(List<EventHandler> eventHandlers) {
        this.eventHandlers = eventHandlers;
    }

    @Override
    public Future<Context> process(Context context) {
        context.setHandled(false);
        return processEventRecursively(context);
    }

    private Future<Context> processEventRecursively(Context context) {
        Future<Context> future = Future.future();
        String eventType = context.getEventType();
        Optional<EventHandler> optionalEventHandler = eventHandlers.stream()
                .filter(eventHandler -> eventHandler.getEventType().equals(eventType))
                .findFirst();
        if (optionalEventHandler.isPresent()) {
            EventHandler eventHandler = optionalEventHandler.get();
            eventHandler.handle(context).setHandler(ar -> {
                if (ar.failed()) {
                    future.fail(ar.cause());
                } else {
                    context.setHandled(true);
                    Context nextContext = ar.result();
                    processEventRecursively(nextContext).setHandler(future);
                }
            });
        } else {
            future.complete(context);
        }
        return future;
    }
}
