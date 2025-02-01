package com.example.LearnModulith.eventaction;

import com.example.LearnModulith.eventaction.action.Action;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(indexes = {

})
@Entity
public class EventAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2, nullable = false)
    private Action action;
    @Column(name="event_can", nullable = false)
    private String eventCanonicalName;
}
