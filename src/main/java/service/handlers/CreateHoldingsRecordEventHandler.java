package service.handlers;

import io.vertx.core.Future;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import model.events.Context;

public class CreateHoldingsRecordEventHandler extends AbstractEventHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(CreateHoldingsRecordEventHandler.class);

    @Override
    public Future<Context> handleContext(Context context) {
        LOGGER.info("Handling event " + getEventType());
        return Future.succeededFuture(context);
    }

    @Override
    public String getEventType() {
        return "CREATED_INVENTORY_INSTANCE";
    }

    @Override
    public String getNextEventType() {
        return "CREATED_HOLDINGS_RECORD";
    }
}
