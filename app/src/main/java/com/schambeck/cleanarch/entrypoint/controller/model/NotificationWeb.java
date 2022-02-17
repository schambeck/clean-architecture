package com.schambeck.cleanarch.entrypoint.controller.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class NotificationWeb implements Serializable {

    private UUID id;
    private String type;
    private String title;
    private String message;
    private Boolean read;
    private String link;

}
