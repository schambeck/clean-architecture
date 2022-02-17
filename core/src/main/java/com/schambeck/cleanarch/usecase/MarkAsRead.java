package com.schambeck.cleanarch.usecase;

import java.util.UUID;

public interface MarkAsRead {

    void execute(UUID id);

}
