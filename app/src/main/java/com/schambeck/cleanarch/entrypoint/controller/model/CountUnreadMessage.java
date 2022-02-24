package com.schambeck.cleanarch.entrypoint.controller.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class CountUnreadMessage {

    private final Long countUnread;
    private final NotificationWeb notification;

}
