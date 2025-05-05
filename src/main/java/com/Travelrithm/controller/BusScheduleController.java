package com.Travelrithm.controller;

import com.Travelrithm.dto.BusScheduleRequestDto;
import com.Travelrithm.dto.BusScheduleResponseDto;
import com.Travelrithm.service.BusScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus-schedules")
@RequiredArgsConstructor
public class BusScheduleController {

    private final BusScheduleService scheduleService;

    @PostMapping
    public BusScheduleResponseDto create(@RequestBody BusScheduleRequestDto request) {
        return scheduleService.createSchedule(request);
    }

    @GetMapping
    public List<BusScheduleResponseDto> getAll() {
        return scheduleService.getAllSchedules();
    }

    @PutMapping("/{id}")
    public BusScheduleResponseDto update(@PathVariable Integer id, @RequestBody BusScheduleRequestDto request) {
        return scheduleService.updateSchedule(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        scheduleService.deleteSchedule(id);
    }
}
