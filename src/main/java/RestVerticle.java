import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import model.events.Context;
import service.handlers.CreateHoldingsRecordEventHandler;
import service.handlers.CreateInstanceEventHandler;
import service.handlers.CreateItemRecordEventHandler;
import service.handlers.EventHandler;
import service.manager.EventManager;
import service.manager.EventManagerImpl;
import service.pubsub.Consumer;
import service.pubsub.Publisher;
import service.pubsub.impl.KafkaConsumer;
import service.pubsub.impl.KafkaPublisher;

import java.util.Arrays;
import java.util.List;

public class RestVerticle extends AbstractVerticle {
    private Consumer consumer;
    private Publisher publisher;
    private EventManager eventManager;

    public RestVerticle() {
        this.consumer = new KafkaConsumer();
        this.publisher = new KafkaPublisher();
        List<EventHandler> eventHandlers = Arrays.asList(
                new CreateInstanceEventHandler(),
                new CreateHoldingsRecordEventHandler(),
                new CreateItemRecordEventHandler()
        );
        this.eventManager = new EventManagerImpl(eventHandlers);
    }

    @Override
    public void start(Future<Void> startFuture) {
        Context context = consumer.consume();
        eventManager.handleEvent(context).setHandler(ar -> {
            if (ar.failed()) {
                //todo LOGGER
            } else {
                Context contextToPublish = ar.result();
                if (contextToPublish != null) {
                    publisher.publish(contextToPublish);
                }
            }
            startFuture.complete();
        });
    }
}
