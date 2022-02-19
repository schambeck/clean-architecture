package com.schambeck.cleanarch.usecase.interactor.impl;

import com.schambeck.cleanarch.dataprovider.NotificationRepository;
import com.schambeck.cleanarch.entity.Notification;
import com.schambeck.cleanarch.usecase.interactor.FindNotification;
import com.schambeck.cleanarch.usecase.interactor.MarkAsRead;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.UUID;

@Named
@RequiredArgsConstructor
class MarkAsReadImpl implements MarkAsRead {

    private final NotificationRepository repository;
    private final FindNotification find;

    @Override
    public void execute(UUID id) {
        Notification notification = find.findById(id);
        repository.markAsRead(notification);
    }
	
}
