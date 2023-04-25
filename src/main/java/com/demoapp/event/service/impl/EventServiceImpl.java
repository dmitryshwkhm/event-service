package com.demoapp.event.service.impl;

import com.demoapp.event.data.model.EventEntity;
import com.demoapp.event.data.repository.EventRepository;
import com.demoapp.event.dto.EventDto;
import com.demoapp.event.service.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Long createEvent(EventDto eventDto) {
        EventEntity eventEntity = modelMapper.map(eventDto, EventEntity.class);
        EventEntity savedEvent = eventRepository.save(eventEntity);
        return savedEvent.getId();
    }

    @Override
    public EventDto getEventById(Long eventId) {
        Optional<EventEntity> eventEntity = eventRepository.findById(eventId);
        return modelMapper.map(eventEntity, EventDto.class);
    }

    @Override
    public List<EventDto> getEvents() {
        List<EventDto> allEvents = new ArrayList<>();
        eventRepository.findAll().forEach(eventEntity -> allEvents.add(modelMapper.map(eventEntity, EventDto.class)));
        return allEvents;
    }
}
