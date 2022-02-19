package com.schambeck.cleanarch.dataprovider;

import com.schambeck.cleanarch.dataprovider.entity.NotificationEntity;
import com.schambeck.cleanarch.dataprovider.mapper.NotificationMapper;
import com.schambeck.cleanarch.entity.Notification;
import com.schambeck.cleanarch.usecase.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.schambeck.cleanarch.dataprovider.mapper.NotificationMapper.toDomain;
import static com.schambeck.cleanarch.dataprovider.mapper.NotificationMapper.toEntity;
import static java.lang.String.format;

@Repository
@RequiredArgsConstructor
class NotificationRepositoryImpl implements NotificationRepository {

	private final JpaNotificationRepository jpaRepository;

	@Override
	public Notification create(Notification notification) {
		NotificationEntity entity = toEntity(notification);
		return toDomain(jpaRepository.save(entity));
	}

	@Override
	public Notification findById(UUID id) {
		NotificationEntity entity = findByIdOrThrow(id);
		return toDomain(entity);
	}

	@Override
	public List<Notification> findAll() {
		return jpaRepository.findAll().stream()
				.map(NotificationMapper::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public void markAsRead(UUID id) {
		NotificationEntity entity = findByIdOrThrow(id);
		entity.setRead(true);
		jpaRepository.save(entity);
	}

	@Override
	public long countByReadIsFalse() {
		return jpaRepository.countByReadIsFalse();
	}

	private NotificationEntity findByIdOrThrow(UUID id) {
		return jpaRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(format("Entity %s not found", id)));
	}

}
