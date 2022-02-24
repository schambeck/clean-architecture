package com.schambeck.cleanarch.entrypoint;

import com.schambeck.cleanarch.entrypoint.controller.model.CountUnreadMessage;
import com.schambeck.cleanarch.entrypoint.controller.model.NotificationWeb;

import java.util.List;
import java.util.UUID;

public interface NotificationEntryPoint {

    NotificationWeb create(NotificationWeb notificationWeb);

    NotificationWeb findById(UUID id);

    List<NotificationWeb> findAll();

    CountUnreadMessage markAsRead(UUID id);

    CountUnreadMessage countUnread();

}
