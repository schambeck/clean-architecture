package com.schambeck.cleanarch.dataprovider;

import com.schambeck.cleanarch.entity.Notification;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NotificationRepository {

    Notification create(Notification notification);

    Optional<Notification> findById(UUID id);

    List<Notification> findAll();

    long countByReadIsFalse();

    void markAsRead(Notification notification);

}
