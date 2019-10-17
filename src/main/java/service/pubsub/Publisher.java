package service.pubsub;

import model.events.Context;

public interface Publisher {

    void publish(Context context);
}
