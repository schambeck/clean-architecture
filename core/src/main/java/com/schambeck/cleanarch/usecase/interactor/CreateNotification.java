package com.schambeck.cleanarch.usecase.interactor;

import com.schambeck.cleanarch.entity.Notification;

public interface CreateNotification {

    Notification execute(Notification notification);

}
