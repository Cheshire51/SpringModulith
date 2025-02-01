package com.example.LearnModulith.eventaction;

import com.example.LearnModulith.eventaction.action.Action;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/event-action")
public class Controller {
    private final RepublishUncompletedEvent republishUncompletedEvent;

    @GetMapping
    public ResponseEntity<String> result(@RequestParam(name="action") String action){
        republishUncompletedEvent.republish(Action.getActionByName(action));
        return new ResponseEntity<>("Event Trigger", HttpStatus.NO_CONTENT);
    }
}
