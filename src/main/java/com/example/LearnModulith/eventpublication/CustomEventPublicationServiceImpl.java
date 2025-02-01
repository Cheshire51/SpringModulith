package com.example.LearnModulith.eventpublication;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomEventPublicationServiceImpl implements CustomEventPublicationService {
    private final CustomEventPublicationRepository eventPublicationRepository;
    @Override
    public List<CustomEventPublication> getUncompletedEventPublications() {
        return eventPublicationRepository.getCustomEventPublicationByPublicationDateNotNullAndCompletionDateIsNull();
    }

    @Override
    public List<CustomEventPublication> getCompletedEventPublications() {
        return eventPublicationRepository.getCustomEventPublicationByPublicationDateNotNullAndCompletionDateIsNotNull();
    }
}
