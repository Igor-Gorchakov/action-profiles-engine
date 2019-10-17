package service.processor;

import io.vertx.core.Future;
import model.events.Context;
import service.handlers.EventHandler;

import java.util.List;
import java.util.Optional;

public class EventProcessorImpl implements EventProcessor {
    private List<EventHandler> eventHandlers;

    public EventProcessorImpl(List<EventHandler> eventHandlers) {
        this.eventHandlers = eventHandlers;
    }

    @Override
    public Future<Context> process(Context context) {
        Future<Context> future = Future.future();
        String eventType = context.get("eventType");
        Optional<EventHandler> optionalEventHandler = eventHandlers.stream()
                .filter(eventHandler -> eventHandler.getEventType().equals(eventType))
                .findFirst();
        if (optionalEventHandler.isPresent()) {
            EventHandler eventHandler = optionalEventHandler.get();
            eventHandler.handle(context).setHandler(future);
        } else {
            // No handler found for eventType, just complete future
            future.complete();
        }
        return future;
    }
}
