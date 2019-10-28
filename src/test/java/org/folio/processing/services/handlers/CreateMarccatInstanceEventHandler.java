package org.folio.processing.services.handlers;

import io.vertx.core.Future;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import org.folio.processing.core.model.EventContext;
import org.folio.processing.core.services.handler.AbstractEventHandler;

public class CreateMarccatInstanceEventHandler extends AbstractEventHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(CreateHoldingsRecordEventHandler.class);

    @Override
    public Future<EventContext> handleContext(EventContext context) {
        LOGGER.info("Handling event " + getHandlerEventType());
        return Future.succeededFuture(context);
    }

    @Override
    public String getHandlerEventType() {
        return "CREATED_ITEM_RECORD";
    }

    @Override
    public String getTargetEventType() {
        return "CREATED_MARCCAT_INSTANCE";
    }
}
