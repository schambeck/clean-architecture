package com.schambeck.cleanarch.dataprovider;

import com.schambeck.cleanarch.dataprovider.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaNotificationRepository extends JpaRepository<NotificationEntity, UUID> {

    long countByReadIsFalse();

}
