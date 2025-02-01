package com.example.LearnModulith.eventaction;

import com.example.LearnModulith.eventaction.action.Action;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EventActionRepository extends CrudRepository<EventAction, Long> {
    Optional<EventAction> getEventActionByAction(Action action);
}
