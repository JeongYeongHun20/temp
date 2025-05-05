package com.Travelrithm.service;

import com.Travelrithm.domain.BusRouteEntity;
import com.Travelrithm.dto.BusRouteRequestDto;
import com.Travelrithm.dto.BusRouteResponseDto;
import com.Travelrithm.repository.BusRouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusRouteService {

    private final BusRouteRepository routeRepository;

    public BusRouteResponseDto createRoute(BusRouteRequestDto request) {
        BusRouteEntity entity = request.toEntity();
        BusRouteEntity saved = routeRepository.save(entity);
        return new BusRouteResponseDto(saved);
    }

    public List<BusRouteResponseDto> getAllRoutes() {
        return routeRepository.findAll()
                .stream()
                .map(BusRouteResponseDto::new)
                .collect(Collectors.toList());
    }

    public BusRouteResponseDto updateRoute(Integer id, BusRouteRequestDto request) {
        BusRouteEntity entity = routeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 노선이 존재하지 않습니다."));
        entity.update(
                request.getRouteName(),
                request.getDepartureTime(),
                request.getArrivalTime(),
                request.getCompanyId(),
                request.getDepartureTerminalId(),
                request.getArrivalTerminalId()
        );
        return new BusRouteResponseDto(entity);
    }

    public void deleteRoute(Integer id) {
        routeRepository.deleteById(id);
    }
}
