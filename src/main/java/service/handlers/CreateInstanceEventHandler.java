package service.handlers;

import io.vertx.core.Future;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import model.events.Context;

public class CreateInstanceEventHandler extends AbstractEventHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(CreateInstanceEventHandler.class);

    @Override
    public Future<Context> handleContext(Context context) {
        LOGGER.info("Handling event " + getEventType());
        return Future.succeededFuture(context);
    }

    @Override
    public String getEventType() {
        return "CREATED_SRS_MARC_BIB_RECORD";
    }

    @Override
    public String getNextEventType() {
        return "CREATED_INVENTORY_INSTANCE";
    }
}
