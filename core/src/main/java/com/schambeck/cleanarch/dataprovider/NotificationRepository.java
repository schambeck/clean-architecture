package com.schambeck.cleanarch.dataprovider;

import com.schambeck.cleanarch.entity.Notification;

import java.util.List;
import java.util.UUID;

public interface NotificationRepository {

    Notification save(Notification notification);

    Notification findById(UUID id);

    List<Notification> findAll();

    void markAsRead(UUID id);

    long countByReadIsFalse();

}
