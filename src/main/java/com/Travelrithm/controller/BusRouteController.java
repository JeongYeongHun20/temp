package com.Travelrithm.controller;

import com.Travelrithm.dto.BusRouteRequestDto;
import com.Travelrithm.dto.BusRouteResponseDto;
import com.Travelrithm.service.BusRouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus-routes")
@RequiredArgsConstructor
public class BusRouteController {

    private final BusRouteService routeService;

    @PostMapping
    public BusRouteResponseDto create(@RequestBody BusRouteRequestDto request) {
        return routeService.createRoute(request);
    }

    @GetMapping
    public List<BusRouteResponseDto> getAll() {
        return routeService.getAllRoutes();
    }

    @PutMapping("/{id}")
    public BusRouteResponseDto update(@PathVariable Integer id, @RequestBody BusRouteRequestDto request) {
        return routeService.updateRoute(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        routeService.deleteRoute(id);
    }
}
