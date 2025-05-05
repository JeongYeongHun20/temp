package com.Travelrithm.controller;

import com.Travelrithm.dto.BusTerminalRequestDto;
import com.Travelrithm.dto.BusTerminalResponseDto;
import com.Travelrithm.service.BusTerminalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/terminals")
@RequiredArgsConstructor
public class BusTerminalController {

    private final BusTerminalService terminalService;

    @PostMapping
    public ResponseEntity<BusTerminalResponseDto> createTerminal(@RequestBody BusTerminalRequestDto request) {
        return ResponseEntity.ok(terminalService.createTerminal(request));
    }

    @GetMapping
    public ResponseEntity<List<BusTerminalResponseDto>> getAllTerminals() {
        return ResponseEntity.ok(terminalService.getAllTerminals());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusTerminalResponseDto> getTerminal(@PathVariable Integer id) {
        return ResponseEntity.ok(terminalService.getTerminalById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusTerminalResponseDto> updateTerminal(
            @PathVariable Integer id, @RequestBody BusTerminalRequestDto request) {
        return ResponseEntity.ok(terminalService.updateTerminal(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTerminal(@PathVariable Integer id) {
        terminalService.deleteTerminal(id);
        return ResponseEntity.noContent().build();
    }
}
