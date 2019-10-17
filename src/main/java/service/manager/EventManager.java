package service.manager;

import io.vertx.core.Future;
import model.events.Context;

public interface EventManager {

    Future<Context> handleEvent(Context event);
}
