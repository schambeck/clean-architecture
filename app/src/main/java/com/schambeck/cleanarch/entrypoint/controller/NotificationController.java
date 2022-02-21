package com.schambeck.cleanarch.entrypoint.controller;

import com.schambeck.cleanarch.entrypoint.controller.model.NotificationWeb;
import com.schambeck.cleanarch.dataprovider.mapper.NotificationMapper;
import com.schambeck.cleanarch.usecase.interactor.MarkAsReadNotification;
import com.schambeck.cleanarch.usecase.interactor.CreateNotification;
import com.schambeck.cleanarch.usecase.interactor.FindNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.schambeck.cleanarch.dataprovider.mapper.NotificationMapper.toDomain;
import static com.schambeck.cleanarch.dataprovider.mapper.NotificationMapper.toWeb;

@Service
@RequiredArgsConstructor
public class NotificationController {

    private final CreateNotification create;
    private final FindNotification find;
    private final MarkAsReadNotification markAsRead;

    public NotificationWeb create(NotificationWeb notificationWeb) {
        var notification = toDomain(notificationWeb);
        return toWeb(create.execute(notification));
    }

    public NotificationWeb findById(UUID id) {
        return toWeb(find.findById(id));
    }

    public List<NotificationWeb> findAll() {
        return find.findAll()
                .stream()
                .map(NotificationMapper::toWeb)
                .collect(Collectors.toList());
    }

    public void markAsRead(UUID id) {
        markAsRead.execute(id);
    }

    public long countByReadIsFalse() {
        return find.countByReadIsFalse();
    }

}
