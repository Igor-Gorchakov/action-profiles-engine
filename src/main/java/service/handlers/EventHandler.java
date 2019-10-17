package service.handlers;

import io.vertx.core.Future;
import model.events.Context;

public interface EventHandler {

    Future<Context> handle(Context context);

    String getEventType();

    String getNextEventType();
}