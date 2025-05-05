package com.Travelrithm.service;

import com.Travelrithm.domain.BusReservEntity;
import com.Travelrithm.dto.BusReservRequestDto;
import com.Travelrithm.dto.BusReservResponseDto;
import com.Travelrithm.repository.BusReservRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BusReservService {

    private final BusReservRepository busReservRepository;

    // CREATE
    public BusReservResponseDto createReservation(BusReservRequestDto dto) {
        BusReservEntity entity = new BusReservEntity();
        entity.setUserId(dto.getUserId());
        entity.setPlanId(dto.getPlanId());
        entity.setDirection(dto.getDirection());
        entity.setDepartureTerminalId(dto.getDepartureTerminalId());
        entity.setArrivalTerminalId(dto.getArrivalTerminalId());
        entity.setDepartureTime(dto.getDepartureTime());
        entity.setSeatNumber(dto.getSeatNumber());
        entity.setSeatStatus(BusReservEntity.SeatStatus.reserved);

        BusReservEntity saved = busReservRepository.save(entity);

        return new BusReservResponseDto(saved);
    }

    // 단건 조회 (READ)
    @Transactional(readOnly = true)
    public BusReservResponseDto findReservation(Integer id) {
        BusReservEntity entity = busReservRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 예매 정보가 존재하지 않습니다."));
        return new BusReservResponseDto(entity);
    }

    // 전체 조회 (READ)
    @Transactional(readOnly = true)
    public List<BusReservResponseDto> findAllReservations() {
        return busReservRepository.findAll().stream()
                .map(BusReservResponseDto::new)
                .toList();
    }

    // UPDATE
    public BusReservResponseDto updateReservation(Integer id, BusReservRequestDto dto) {
        BusReservEntity entity = busReservRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 예매 정보가 존재하지 않습니다."));
        entity.setUserId(dto.getUserId());
        entity.setPlanId(dto.getPlanId());
        entity.setDirection(dto.getDirection());
        entity.setDepartureTerminalId(dto.getDepartureTerminalId());
        entity.setArrivalTerminalId(dto.getArrivalTerminalId());
        entity.setDepartureTime(dto.getDepartureTime());
        entity.setSeatNumber(dto.getSeatNumber());
        // 필요한 경우 seatStatus 수정 (dto에 포함되어 있다면)
        // entity.setSeatStatus(dto.getSeatStatus());
        return new BusReservResponseDto(entity);
    }

    // DELETE
    public void deleteReservation(Integer id) {
        busReservRepository.deleteById(id);
    }
}
