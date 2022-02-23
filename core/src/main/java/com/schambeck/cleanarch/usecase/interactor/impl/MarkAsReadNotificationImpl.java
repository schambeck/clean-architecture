package com.schambeck.cleanarch.usecase.interactor.impl;

import com.schambeck.cleanarch.dataprovider.NotificationRepository;
import com.schambeck.cleanarch.usecase.interactor.MarkAsReadNotification;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.UUID;

@Named
@RequiredArgsConstructor
class MarkAsReadNotificationImpl implements MarkAsReadNotification {

    private final NotificationRepository repository;

    @Override
    public void execute(UUID id) {
        repository.updateRead(id, true);
    }
	
}
