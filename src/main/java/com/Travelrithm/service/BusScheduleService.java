package com.Travelrithm.service;

import com.Travelrithm.domain.BusScheduleEntity;
import com.Travelrithm.dto.BusScheduleRequestDto;
import com.Travelrithm.dto.BusScheduleResponseDto;
import com.Travelrithm.repository.BusScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusScheduleService {

    private final BusScheduleRepository scheduleRepository;

    public BusScheduleResponseDto createSchedule(BusScheduleRequestDto request) {
        BusScheduleEntity entity = request.toEntity();
        return new BusScheduleResponseDto(scheduleRepository.save(entity));
    }

    public List<BusScheduleResponseDto> getAllSchedules() {
        return scheduleRepository.findAll()
                .stream()
                .map(BusScheduleResponseDto::new)
                .collect(Collectors.toList());
    }

    public BusScheduleResponseDto updateSchedule(Integer id, BusScheduleRequestDto request) {
        BusScheduleEntity entity = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 스케줄이 존재하지 않습니다."));
        entity.update(request.getRouteId(), request.getDepartureTime(), request.getAvailableSeats());
        return new BusScheduleResponseDto(entity);
    }

    public void deleteSchedule(Integer id) {
        scheduleRepository.deleteById(id);
    }
}
