package service.pubsub.impl;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import model.events.Context;
import model.profiles.ProfileSnapshotBuilder;
import model.profiles.ProfileSnapshotWrapper;
import service.pubsub.Consumer;

import java.util.ArrayList;
import java.util.List;

public class KafkaConsumer implements Consumer {
    private final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Override
    public Context consume() {
        ProfileSnapshotWrapper profileSnapshot = ProfileSnapshotBuilder.build();
        ProfileSnapshotWrapper currentNode = profileSnapshot.getChildren().get(1).getChildren().get(0).getChildren().get(0);
        List<String> currentNodePath = new ArrayList<>();
        currentNodePath.add("70b7115f-c8e4-444a-9b24-ad290e1eaf12");
        currentNodePath.add("905b85cb-4fbc-4a45-8d2f-f1322eaf0629");
        currentNodePath.add("6121feb7-59e9-4844-b89a-d3f144aa5fa5");
        currentNodePath.add("435a3472-a17c-44f8-8046-1266d5878379");

        Context context = new Context();
        context.setProfileSnapshot(profileSnapshot);
        context.setEventType("CREATED_SRS_MARC_BIB_RECORD");
//        context.setEventType("CREATED_INVENTORY_INSTANCE");
//        context.setEventType("UNDEFINED");
        context.setCurrentNode(currentNode);
        context.setCurrentNodePath(currentNodePath);
        LOGGER.info("Consume new event: " + context.toString());
        return context;
    }
}
