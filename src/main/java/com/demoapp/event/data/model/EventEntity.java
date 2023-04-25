package com.demoapp.event.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "Event")
@Getter
@Setter
public class EventEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String title;

    @Column(nullable = false, length = 50)
	private String place;

    @Column(nullable = false, length = 50)
	private String speaker;

    private EventType eventType;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
}
