package service.manager;

import io.vertx.core.Future;
import model.events.Context;
import model.profiles.ProfileSnapshotWrapper;
import service.handlers.EventHandler;
import service.processor.EventProcessor;
import service.processor.RecursiveEventProcessor;

import java.util.List;
import java.util.Optional;

public class EventManagerImpl implements EventManager {
    private EventProcessor eventProcessor;

    public EventManagerImpl(List<EventHandler> eventHandlers) {
        this.eventProcessor = new RecursiveEventProcessor(eventHandlers);
    }

    @Override
    public Future<Context> handleEvent(Context context) {
        Future<Context> future = Future.future();
        eventProcessor.process(context).setHandler(firstAr -> {
            if (firstAr.failed()) {
                future.fail(firstAr.cause());
            } else {
                if (context.isHandled()) {
                    future.complete(prepareContext(context));
                } else {
                    future.complete();
                }
            }
        });
        return future;
    }

    private Context prepareContext(Context context) {
        ProfileSnapshotWrapper snapshotWrapper = context.getProfileSnapshot();
        List<String> currentNodePath = context.getCurrentNodePath();
        Optional<ProfileSnapshotWrapper> optionalNextNode = findSnapshotWrapperByPath(snapshotWrapper, currentNodePath);
        if (optionalNextNode.isPresent()) {
            ProfileSnapshotWrapper nextNode = optionalNextNode.get();
            context.setCurrentNode(nextNode);
            currentNodePath.add(nextNode.getId());
            context.setCurrentNodePath(currentNodePath);
            return context;
        } else {
            // No next node, all profiles are processed, nothing to publish
            return null;
        }
    }

    private Optional<ProfileSnapshotWrapper> findSnapshotWrapperByPath(ProfileSnapshotWrapper currentWrapper, List<String> path) {
        Optional<ProfileSnapshotWrapper> profileSnapshotWrapper = Optional.of(currentWrapper);
        return profileSnapshotWrapper;
    }
}