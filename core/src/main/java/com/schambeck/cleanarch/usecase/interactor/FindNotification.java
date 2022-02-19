package com.schambeck.cleanarch.usecase.interactor;

import com.schambeck.cleanarch.entity.Notification;

import java.util.List;
import java.util.UUID;

public interface FindNotification {

    Notification findById(UUID id);

    List<Notification> findAll();

    long countByReadIsFalse();

}
