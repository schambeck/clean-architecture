package com.schambeck.cleanarch.entity.vo;

import com.schambeck.cleanarch.entity.Notification;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder(toBuilder = true)
@RequiredArgsConstructor
public class CountUnreadMessage {

    private final Long countUnread;
    private final Notification notification;

}
