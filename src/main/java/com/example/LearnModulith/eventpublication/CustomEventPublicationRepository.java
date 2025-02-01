package com.example.LearnModulith.eventpublication;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CustomEventPublicationRepository extends CrudRepository<CustomEventPublication, UUID> {
    List<CustomEventPublication> getCustomEventPublicationByPublicationDateNotNullAndCompletionDateIsNull();
    List<CustomEventPublication> getCustomEventPublicationByPublicationDateNotNullAndCompletionDateIsNotNull();
}
