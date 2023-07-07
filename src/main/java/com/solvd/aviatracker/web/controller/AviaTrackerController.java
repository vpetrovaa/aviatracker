package com.solvd.aviatracker.web.controller;

import com.solvd.aviatracker.domain.Message;
import com.solvd.aviatracker.service.AviatrackerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/aviatracker")
@RequiredArgsConstructor
public final class AviaTrackerController {

    private final AviatrackerService aviatrackerService;

    @PostMapping
    public void sendMessage(@RequestBody final Message message) {
        aviatrackerService.send(message);
    }

}
