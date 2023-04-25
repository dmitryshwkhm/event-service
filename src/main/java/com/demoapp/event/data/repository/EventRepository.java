package com.demoapp.event.data.repository;

import com.demoapp.event.data.model.EventEntity;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<EventEntity, Long> {
}
