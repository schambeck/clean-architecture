package com.schambeck.cleanarch.entity;

import com.schambeck.cleanarch.entity.vo.TypeNotification;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class Notification implements Serializable {

    private UUID id;
    private TypeNotification type;
    private String title;
    private String message;
    private Boolean read;
    private String link;

}
