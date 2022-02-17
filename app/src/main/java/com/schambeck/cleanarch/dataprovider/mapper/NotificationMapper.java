package com.schambeck.cleanarch.dataprovider.mapper;

import com.schambeck.cleanarch.entrypoint.controller.model.NotificationWeb;
import com.schambeck.cleanarch.dataprovider.entity.NotificationEntity;
import com.schambeck.cleanarch.entity.Notification;
import com.schambeck.cleanarch.entity.vo.TypeNotification;

public final class NotificationMapper {

    public static NotificationWeb toWeb(Notification notification) {
        if (notification == null) {
            return null;
        }
        return NotificationWeb.builder()
                .id(notification.getId())
                .type(notification.getType().toString())
                .title(notification.getTitle())
                .message(notification.getMessage())
                .read(notification.getRead())
                .link(notification.getLink())
                .build();
    }

    public static NotificationEntity toEntity(Notification notification) {
        if (notification == null) {
            return null;
        }
        return NotificationEntity.builder()
                .id(notification.getId())
                .type(com.schambeck.cleanarch.dataprovider.entity.TypeNotification.valueOf(notification.getType().toString()))
                .title(notification.getTitle())
                .message(notification.getMessage())
                .read(notification.getRead())
                .link(notification.getLink())
                .build();
    }

    public static Notification toDomain(NotificationWeb notification) {
        if (notification == null) {
            return null;
        }
        return Notification.builder()
                .id(notification.getId())
                .type(TypeNotification.valueOf(notification.getType()))
                .title(notification.getTitle())
                .message(notification.getMessage())
                .read(notification.getRead())
                .link(notification.getLink())
                .build();
    }

    public static Notification toDomain(NotificationEntity notification) {
        if (notification == null) {
            return null;
        }
        return Notification.builder()
                .id(notification.getId())
                .type(TypeNotification.valueOf(notification.getType().toString()))
                .title(notification.getTitle())
                .message(notification.getMessage())
                .read(notification.getRead())
                .link(notification.getLink())
                .build();
    }

}
