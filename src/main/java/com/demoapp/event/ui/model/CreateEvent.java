package com.demoapp.event.ui.model;

import com.demoapp.event.data.model.EventType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateEvent {
    private String title;

    private String place;

    private String speaker;

    private EventType eventType;

    private String dateTime;
}
