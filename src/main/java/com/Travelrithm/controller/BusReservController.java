package com.Travelrithm.controller;

import com.Travelrithm.dto.BusReservRequestDto;
import com.Travelrithm.dto.BusReservResponseDto;
import com.Travelrithm.service.BusReservService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bus-reservations")
public class BusReservController {

    private final BusReservService busReservService;

    @PostMapping
    public ResponseEntity<BusReservResponseDto> createReservation(@RequestBody BusReservRequestDto dto) {
        return ResponseEntity.ok(busReservService.createReservation(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusReservResponseDto> getReservationById(@PathVariable Integer id) {
        return ResponseEntity.ok(busReservService.findReservation(id));
    }

    @GetMapping
    public ResponseEntity<List<BusReservResponseDto>> getAllReservations() {
        return ResponseEntity.ok(busReservService.findAllReservations());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusReservResponseDto> updateReservation(@PathVariable Integer id,
                                                                  @RequestBody BusReservRequestDto dto) {
        return ResponseEntity.ok(busReservService.updateReservation(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Integer id) {
        busReservService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}
