package com.schambeck.cleanarch.dataprovider.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "notification")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(of = "id", callSuper = false)
public class NotificationEntity {

    @Id
    private UUID id;

    @Enumerated(STRING)
    @Column(name = "type")
    private TypeNotification type;

    @Column(name = "title")
    private String title;

    @Column(name = "message")
    private String message;

    @Column(name = "link")
    private String link;

    @Column(name = "read")
    private Boolean read;

}
