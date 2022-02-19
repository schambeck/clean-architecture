package com.schambeck.cleanarch.usecase.interactor.impl;

import com.schambeck.cleanarch.dataprovider.NotificationRepository;
import com.schambeck.cleanarch.entity.Notification;
import com.schambeck.cleanarch.usecase.generator.IdGenerator;
import com.schambeck.cleanarch.usecase.interactor.CreateNotification;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
class CreateNotificationImpl implements CreateNotification {

    private final NotificationRepository repository;
	private final IdGenerator idGenerator;

    @Override
	public Notification execute(Notification notification) {
		Notification toCreate = notification.toBuilder()
			.id(idGenerator.generate())
			.read(false)
			.build();
		return repository.create(toCreate);
    }

}
