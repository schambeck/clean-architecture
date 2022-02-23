package com.schambeck.cleanarch.dataprovider;

import com.schambeck.cleanarch.dataprovider.entity.NotificationEntity;
import com.schambeck.cleanarch.dataprovider.mapper.NotificationMapper;
import com.schambeck.cleanarch.entity.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.schambeck.cleanarch.dataprovider.mapper.NotificationMapper.toDomain;
import static com.schambeck.cleanarch.dataprovider.mapper.NotificationMapper.toEntity;

@Repository
@RequiredArgsConstructor
class NotificationGateway implements NotificationRepository {

	private final JpaNotificationRepository jpaRepository;

	@Override
	public Notification create(Notification notification) {
		NotificationEntity entity = toEntity(notification);
		return toDomain(jpaRepository.save(entity));
	}

	@Override
	public Optional<Notification> findById(UUID id) {
		return jpaRepository.findById(id)
				.map(NotificationMapper::toDomain);
	}

	@Override
	public List<Notification> findAll() {
		return jpaRepository.findAll().stream()
				.map(NotificationMapper::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public void updateRead(UUID id, Boolean read) {
		jpaRepository.updateRead(id, read);
	}

	@Override
	public long countUnread() {
		return jpaRepository.countByReadIsFalse();
	}

}
