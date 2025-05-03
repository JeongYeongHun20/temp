package com.Travelrithm.service;

import com.Travelrithm.domain.BusTerminalEntity;
import com.Travelrithm.dto.BusTerminalRequestDto;
import com.Travelrithm.dto.BusTerminalResponseDto;
import com.Travelrithm.repository.BusTerminalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BusTerminalService {

    private final BusTerminalRepository terminalRepository;

    public BusTerminalResponseDto createTerminal(BusTerminalRequestDto request) {
        BusTerminalEntity entity = request.toEntity();
        entity.setCreatedAt(LocalDateTime.now());
        terminalRepository.save(entity);
        return new BusTerminalResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<BusTerminalResponseDto> getAllTerminals() {
        return terminalRepository.findAll().stream()
                .map(BusTerminalResponseDto::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public BusTerminalResponseDto getTerminalById(Integer id) {
        BusTerminalEntity entity = terminalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 터미널이 존재하지 않습니다."));
        return new BusTerminalResponseDto(entity);
    }

    public BusTerminalResponseDto updateTerminal(Integer id, BusTerminalRequestDto request) {
        BusTerminalEntity entity = terminalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 터미널이 존재하지 않습니다."));
        entity.update(request);
        return new BusTerminalResponseDto(entity);
    }

    public void deleteTerminal(Integer id) {
        terminalRepository.deleteById(id);
    }
}

