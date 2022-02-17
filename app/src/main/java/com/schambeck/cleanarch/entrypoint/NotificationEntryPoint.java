package com.schambeck.cleanarch.entrypoint;

import com.schambeck.cleanarch.entrypoint.controller.model.NotificationWeb;
import com.schambeck.cleanarch.entity.vo.CountUnreadMessage;

import java.util.List;
import java.util.UUID;

public interface NotificationEntryPoint {

    NotificationWeb create(NotificationWeb notificationWeb);

    NotificationWeb findById(UUID id);

    List<NotificationWeb> findAll();

    CountUnreadMessage countUnread();

}
