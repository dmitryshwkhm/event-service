package com.demoapp.event.service;

import com.demoapp.event.dto.EventDto;

import java.util.List;

public interface EventService {
    Long createEvent(EventDto eventDto);

    EventDto getEventById(Long eventId);

    List<EventDto> getEvents();
}
