package com.schambeck.cleanarch.usecase.interactor.impl;

import com.schambeck.cleanarch.dataprovider.NotificationRepository;
import com.schambeck.cleanarch.entity.Notification;
import com.schambeck.cleanarch.usecase.generator.IdGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static com.schambeck.cleanarch.entity.vo.TypeNotification.SSE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateNotificationImplTest {
    @InjectMocks
    CreateNotificationImpl createNotification;
    @Mock
    NotificationRepository repository;
    @Mock
    IdGenerator idGenerator;
    
    @Test
    void execute() {
        Notification notification = Notification.builder().type(SSE).title("Order created #1").message("Created at 2023-02-03").link("/orders/1").build();
        UUID id = UUID.fromString("c16bb17a-afc0-4690-a041-15528a4db7a2");
        Notification createdMock = notification.toBuilder().id(id).read(false).build();
        Notification toCreate = Notification.builder().id(id).type(SSE).title("Order created #1").message("Created at 2023-02-03").link("/orders/1").build();
        when(idGenerator.generate()).thenReturn(id);
        when(repository.create(toCreate)).thenReturn(createdMock);
        
        Notification created = createNotification.execute(notification);
        
        assertNotNull(created);
        assertEquals(id, created.getId());
        assertEquals(SSE, created.getType());
        assertEquals("Order created #1", created.getTitle());
        assertEquals("Created at 2023-02-03", created.getMessage());
        assertEquals(false, created.getRead());
        assertEquals("/orders/1", created.getLink());
    }
}
