package com.schambeck.cleanarch.usecase.interactor.impl;

import com.schambeck.cleanarch.dataprovider.NotificationRepository;
import com.schambeck.cleanarch.entity.Notification;
import com.schambeck.cleanarch.usecase.exception.NotFoundException;
import com.schambeck.cleanarch.usecase.interactor.FindNotification;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.List;
import java.util.UUID;

import static java.lang.String.format;

@Named
@RequiredArgsConstructor
class FindNotificationImpl implements FindNotification {

    private final NotificationRepository repository;

    @Override
    public Notification findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(format("Entity %s not found", id)));
    }

    @Override
    public List<Notification> findAll() {
        return repository.findAll();
    }

    @Override
    public long countByReadIsFalse() {
        return repository.countByReadIsFalse();
    }

}
