package com.schambeck.cleanarch.usecase.interactor.impl;

import com.schambeck.cleanarch.dataprovider.NotificationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CountUnreadNotificationImplTest {
    @InjectMocks
    CountUnreadNotificationImpl countUnread;
    @Mock
    NotificationRepository repository;
    
    @Test
    void execute() {
        when(repository.countUnread()).thenReturn(10L);
        
        long count = countUnread.execute();
        
        assertEquals(10, count);
    }
}
