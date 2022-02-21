package com.schambeck.cleanarch.usecase.interactor;

import java.util.UUID;

public interface MarkAsReadNotification {

    void execute(UUID id);

}
