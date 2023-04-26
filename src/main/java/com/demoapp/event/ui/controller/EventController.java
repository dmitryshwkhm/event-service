package com.demoapp.event.ui.controller;

import com.demoapp.event.dto.EventDto;
import com.demoapp.event.service.EventService;
import com.demoapp.event.ui.model.CreateEvent;
import com.demoapp.event.ui.model.GetEvent;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EventService eventService;

    @PostMapping(
            consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<Long> createEvent(@RequestBody @Valid CreateEvent createEvent)
    {
        EventDto eventDto = modelMapper.map(createEvent, EventDto.class);
        Long id = eventService.createEvent(eventDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @GetMapping(
            value = "/{eventId}",
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<GetEvent> getEvent(@PathVariable @NotNull Long eventId)
    {
        EventDto eventDto = eventService.getEventById(eventId);
        GetEvent getEvent = modelMapper.map(eventDto, GetEvent.class);
        return ResponseEntity.status(HttpStatus.OK).body(getEvent);
    }

    @GetMapping(
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<List<GetEvent>> getEvent()
    {
        List<EventDto> eventsDto = eventService.getEvents();
        List<GetEvent> getEvents = eventsDto.stream().map(event -> modelMapper.map(event, GetEvent.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(getEvents);
    }
}
