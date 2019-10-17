package service.pubsub.impl;

import io.vertx.core.json.Json;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import model.events.Context;
import model.profiles.ProfileSnapshotBuilder;
import model.profiles.ProfileSnapshotWrapper;
import service.pubsub.Consumer;

public class KafkaConsumer implements Consumer {
    private final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Override
    public Context consume() {
        ProfileSnapshotWrapper profileSnapshot = ProfileSnapshotBuilder.build();
        ProfileSnapshotWrapper currentNode = profileSnapshot.getChildren().get(1).getChildren().get(0).getChildren().get(0);
        String currentNodePath = "70b7115f-c8e4-444a-9b24-ad290e1eaf12" +
                ".905b85cb-4fbc-4a45-8d2f-f1322eaf0629" +
                ".6121feb7-59e9-4844-b89a-d3f144aa5fa5" +
                ".435a3472-a17c-44f8-8046-1266d5878379";
        Context context = new Context();
        context.put("eventType", "CREATED_SRS_MARC_BIB_RECORD");
//        context.put("eventType", "CREATED_INVENTORY_INSTANCE");
//        context.put("eventType", "UNDEFINED");
        context.put("currentNode", Json.encode(currentNode));
        context.put("currentNodePath", currentNodePath);
        context.put("profileSnapshot", Json.encodeToBuffer(profileSnapshot).toString());
        LOGGER.info("Consume new event: " + context.toString());
        return context;
    }
}
