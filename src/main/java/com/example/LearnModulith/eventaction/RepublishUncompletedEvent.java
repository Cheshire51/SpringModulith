package com.example.LearnModulith.eventaction;

import com.example.LearnModulith.eventaction.action.Action;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.modulith.events.CompletedEventPublications;
import org.springframework.modulith.events.IncompleteEventPublications;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class RepublishUncompletedEvent {
    private final EventActionRepository eventActionRepository;
    private final IncompleteEventPublications incompleteEventPublications;
    private final CompletedEventPublications completedEventPublications;
    private final Environment env;

    public void republish(Action action) {
        Optional<EventAction> optionalEventAction = eventActionRepository.getEventActionByAction(action);

        if (optionalEventAction.isEmpty()) {
            log.info("No event action found for action {}", action);
        }

        if (optionalEventAction.isPresent()) {
            log.info("Republishing event for action {}", action);

            EventAction eventAction = optionalEventAction.get();

            try {
                Class<?> actionClass = Class.forName(eventAction.getEventCanonicalName());
                incompleteEventPublications.resubmitIncompletePublications((ep) ->
                        ep.getEvent().getClass() == actionClass
                );
                //completedEventPublications.deletePublicationsOlderThan(Duration.ofHours(env.getProperty("delete.event.duration", Long.class, 100L)));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void republish(List<Action> actions)
    {
        actions.forEach(this::republish);
    }

    //@Scheduled(cron = "0 0 0 * * *")
    @Scheduled(fixedRate = 10L, timeUnit = TimeUnit.SECONDS)
    public  void republishAll()
    {
        log.info("Republishing all events");
        for (Action action: Action.values()) {
            republish(action);
        }
    }

}
