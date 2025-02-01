package com.example.LearnModulith.eventpublication;

import java.util.List;

public interface CustomEventPublicationService {
    List<CustomEventPublication> getUncompletedEventPublications();
    List<CustomEventPublication> getCompletedEventPublications();
}
