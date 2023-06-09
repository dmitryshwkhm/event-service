package com.demoapp.event.dto;

import com.demoapp.event.data.model.EventType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class EventDto implements Serializable {
    private Long id;

    private String title;

    private String place;

    private String speaker;

    private EventType eventType;

    private Date dateTime;
}
