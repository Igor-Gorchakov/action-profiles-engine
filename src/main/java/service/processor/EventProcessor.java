package service.processor;

import io.vertx.core.Future;
import model.events.Context;

public interface EventProcessor {

    Future<Context> process(Context context);
}
