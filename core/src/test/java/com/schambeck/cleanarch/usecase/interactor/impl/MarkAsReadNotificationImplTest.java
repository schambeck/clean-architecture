package com.schambeck.cleanarch.usecase.interactor.impl;

import com.schambeck.cleanarch.dataprovider.NotificationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MarkAsReadNotificationImplTest {
    @InjectMocks
    MarkAsReadNotificationImpl markAsRead;
    @Mock
    NotificationRepository repository;
    
    @Test
    void execute() {
        UUID id = UUID.fromString("c16bb17a-afc0-4690-a041-15528a4db7a2");
        
        markAsRead.execute(id);
        
        verify(repository).updateRead(id, true);
    }
    
}
