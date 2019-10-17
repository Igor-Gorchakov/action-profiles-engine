package service.pubsub.impl;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import model.events.Context;
import service.pubsub.Publisher;

public class KafkaPublisher implements Publisher {
    private final Logger LOGGER = LoggerFactory.getLogger(KafkaPublisher.class);

    @Override
    public void publish(Context context) {
        LOGGER.info("Publish " + context);
    }
}
