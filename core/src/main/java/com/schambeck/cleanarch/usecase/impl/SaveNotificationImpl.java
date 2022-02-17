package com.schambeck.cleanarch.usecase.impl;

import com.schambeck.cleanarch.dataprovider.NotificationRepository;
import com.schambeck.cleanarch.entity.Notification;
import com.schambeck.cleanarch.usecase.generator.IdGenerator;
import com.schambeck.cleanarch.usecase.SaveNotification;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
class SaveNotificationImpl implements SaveNotification {

    private final NotificationRepository repository;
	private final IdGenerator idGenerator;

    @Override
	public Notification save(Notification notification) {
		Notification toSave = notification.toBuilder()
			.id(idGenerator.generate())
			.read(false)
			.build();
		return repository.save(toSave);
    }

}
