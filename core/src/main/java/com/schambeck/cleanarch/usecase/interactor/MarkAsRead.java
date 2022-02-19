package com.schambeck.cleanarch.usecase.interactor;

import java.util.UUID;

public interface MarkAsRead {

    void execute(UUID id);

}
