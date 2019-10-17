package service.pubsub;

import model.events.Context;

public interface Consumer {

    Context consume();
}
