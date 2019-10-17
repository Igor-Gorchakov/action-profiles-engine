package service.handlers;

import io.vertx.core.Future;
import model.events.Context;

public abstract class AbstractEventHandler implements EventHandler {

    @Override
    public Future<Context> handle(Context context) {
        Future<Context> future = Future.future();
        handleContext(context)
                .compose(nextContext -> Future.succeededFuture(prepareNextContext(nextContext)))
                .setHandler(future);
        return future;
    }

    protected abstract Future<Context> handleContext(Context context);

    protected Context prepareNextContext(Context context) {
        try {
            context.getObjects().replace("eventType", getNextEventType());
            String eventChain = context.get("eventChain");
            eventChain.concat("." + getEventType());
            context.getObjects().replace("eventChain", eventChain);
            return context;
        } catch (Exception e) {
            // LOGGER
            return context;
        }
    }
}
