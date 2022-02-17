package com.schambeck.cleanarch.entrypoint.rest;

import com.schambeck.cleanarch.entrypoint.controller.NotificationController;
import com.schambeck.cleanarch.entrypoint.controller.model.NotificationWeb;
import com.schambeck.cleanarch.entity.vo.CountUnreadMessage;
import com.schambeck.cleanarch.entrypoint.NotificationEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
class NotificationRestEntryPoint implements NotificationEntryPoint {

	private final NotificationController controller;

	@Override
	@PostMapping
	public NotificationWeb create(@RequestBody NotificationWeb notificationWeb) {
		return controller.save(notificationWeb);
	}

	@Override
	@GetMapping("/{id}")
	public NotificationWeb findById(@PathVariable("id") UUID id) {
		return controller.findById(id);
	}

	@Override
	@GetMapping
	public List<NotificationWeb> findAll() {
		return controller.findAll();
	}

	@PutMapping("/{id}/actions/mark-as-read")
	@ResponseStatus(OK)
	void markAsRead(@PathVariable("id") UUID id) {
		controller.markAsRead(id);
//		return sendNotification(countUnread);
	}

	@Override
	@GetMapping("/queries/count-unread")
	@ResponseStatus(OK)
	public CountUnreadMessage countUnread() {
		return CountUnreadMessage.builder()
				.countUnread(controller.countByReadIsFalse())
				.build();
	}

}
