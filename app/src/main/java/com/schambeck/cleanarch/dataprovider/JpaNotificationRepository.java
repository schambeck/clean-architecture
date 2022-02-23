package com.schambeck.cleanarch.dataprovider;

import com.schambeck.cleanarch.dataprovider.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

interface JpaNotificationRepository extends JpaRepository<NotificationEntity, UUID> {

    long countByReadIsFalse();

    @Transactional
    @Modifying
    @Query("UPDATE NotificationEntity n SET n.read = :read WHERE n.id = :id")
    void updateRead(@Param("id") UUID id, @Param("read") Boolean read);

}
