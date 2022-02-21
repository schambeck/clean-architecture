package com.schambeck.cleanarch.usecase.interactor.impl;

import com.schambeck.cleanarch.dataprovider.NotificationRepository;
import com.schambeck.cleanarch.usecase.interactor.CountUnreadNotification;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
class CountUnreadNotificationImpl implements CountUnreadNotification {

    private final NotificationRepository repository;

    @Override
    public long execute() {
        return repository.countUnread();
    }

}
