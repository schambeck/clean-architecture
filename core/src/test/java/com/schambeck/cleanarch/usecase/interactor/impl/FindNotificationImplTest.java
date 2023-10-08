package com.schambeck.cleanarch.usecase.interactor.impl;

import com.schambeck.cleanarch.dataprovider.NotificationRepository;
import com.schambeck.cleanarch.entity.Notification;
import com.schambeck.cleanarch.usecase.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.schambeck.cleanarch.entity.vo.TypeNotification.SSE;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindNotificationImplTest {
    @InjectMocks
    FindNotificationImpl findNotification;
    @Mock
    NotificationRepository repository;
    
    @Test
    void findById() {
        UUID id = UUID.fromString("c16bb17a-afc0-4690-a041-15528a4db7a2");
        Notification notification = Notification.builder().id(id).type(SSE).title("Order created #1").message("Created at 2023-02-03").read(true).link("/orders/1").build();
        when(repository.findById(id)).thenReturn(Optional.of(notification));
        
        Notification found = findNotification.findById(id);
        
        assertNotNull(found);
        assertEquals(id, found.getId());
        assertEquals(SSE, found.getType());
        assertEquals("Order created #1", found.getTitle());
        assertEquals("Created at 2023-02-03", found.getMessage());
        assertEquals(true, found.getRead());
        assertEquals("/orders/1", found.getLink());
    }
    
    @Test
    void findByIdNotFound() {
        UUID id = UUID.fromString("c16bb17a-afc0-4690-a041-15528a4db7a2");
        when(repository.findById(id)).thenReturn(Optional.empty());
        
        NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> findNotification.findById(id));
        
        assertEquals(format("Entity %s not found", id), notFoundException.getMessage());
    }
    
    @Test
    void findAll() {
        UUID id = UUID.fromString("c16bb17a-afc0-4690-a041-15528a4db7a2");
        Notification notification = Notification.builder().id(id).type(SSE).title("Order created #1").message("Created at 2023-02-03").read(true).link("/orders/1").build();
        when(repository.findAll()).thenReturn(List.of(notification));
        
        List<Notification> notifications = findNotification.findAll();
        
        assertNotNull(notifications);
        assertIterableEquals(List.of(notification), notifications);
        Notification found = notifications.get(0);
        assertEquals(id, found.getId());
        assertEquals(SSE, found.getType());
        assertEquals("Order created #1", found.getTitle());
        assertEquals("Created at 2023-02-03", found.getMessage());
        assertEquals(true, found.getRead());
        assertEquals("/orders/1", found.getLink());
    }
}
