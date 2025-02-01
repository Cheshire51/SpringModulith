package com.example.LearnModulith.eventpublication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationModuleTest
class EventPublicationIntegrationTest {
    @Autowired
    CustomEventPublicationService customEventPublicationService;

    @Test
    void getUncompletedEventPublicationsTest() {
        List<CustomEventPublication> list = customEventPublicationService.getUncompletedEventPublications();
        list.forEach(ev->{
                    assertThat(ev).isInstanceOf(CustomEventPublication.class);
                    assertThat(ev.getCompletionDate()).isNull();
                });

    }

    @Test
    void getCompletedEventPublicationsTest() {
        List<CustomEventPublication> list = customEventPublicationService.getCompletedEventPublications();
        list.forEach(ev->{
            assertThat(ev).isInstanceOf(CustomEventPublication.class);
            assertThat(ev.getCompletionDate()).isNotNull();
        });

    }
}