package com.pragma.traceability.infrastructure.input.rest;

import com.pragma.messaging.application.handler.INotificationHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/messaging")
@Slf4j
public class NotificationRestController {
    private final INotificationHandler iNotificationHandler;

    @Post
}
