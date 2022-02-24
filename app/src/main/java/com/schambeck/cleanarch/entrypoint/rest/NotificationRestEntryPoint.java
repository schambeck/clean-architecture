package com.schambeck.cleanarch.entrypoint.rest;

import com.schambeck.cleanarch.entrypoint.NotificationEntryPoint;
import com.schambeck.cleanarch.entrypoint.controller.model.CountUnreadMessage;
import com.schambeck.cleanarch.entrypoint.controller.NotificationController;
import com.schambeck.cleanarch.entrypoint.controller.model.NotificationWeb;
import com.schambeck.cleanarch.entrypoint.controller.sse.SseEmitters;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
class NotificationRestEntryPoint implements NotificationEntryPoint {

	private final NotificationController controller;
	private final SseEmitters emitters;

	@Override
	@PostMapping
	public NotificationWeb create(@RequestBody NotificationWeb notificationWeb) {
		NotificationWeb created = controller.create(notificationWeb);
		long countUnread = controller.countUnread();
		sendNotification(countUnread, created);
		return created;
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

	@Override
	@PutMapping("/{id}/actions/mark-as-read")
	@ResponseStatus(OK)
	public CountUnreadMessage markAsRead(@PathVariable("id") UUID id) {
		controller.markAsRead(id);
		long countUnread = controller.countUnread();
		return sendNotification(countUnread);
	}

	@Override
	@GetMapping("/queries/count-unread")
	@ResponseStatus(OK)
	public CountUnreadMessage countUnread() {
		return CountUnreadMessage.builder()
				.countUnread(controller.countUnread())
				.build();
	}

	private CountUnreadMessage sendNotification(long countUnread) {
		return sendNotification(countUnread, null);
	}

	private CountUnreadMessage sendNotification(long countUnread, NotificationWeb notification) {
		CountUnreadMessage message = CountUnreadMessage.builder()
				.countUnread(countUnread)
				.notification(notification)
				.build();
		emitters.send(message);
		log.info("Message sent: {}", message);
		return message;
	}

}
