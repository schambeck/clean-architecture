package com.schambeck.cleanarch.entity;

import com.schambeck.cleanarch.entity.vo.TypeNotification;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Notification implements Serializable {

    @EqualsAndHashCode.Include
    private UUID id;
    private TypeNotification type;
    private String title;
    private String message;
    private Boolean read;
    private String link;

}
