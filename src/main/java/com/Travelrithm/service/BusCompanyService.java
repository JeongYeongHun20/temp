package com.Travelrithm.service;

import com.Travelrithm.domain.BusCompanyEntity;
import com.Travelrithm.dto.BusCompanyRequestDto;
import com.Travelrithm.dto.BusCompanyResponseDto;
import com.Travelrithm.repository.BusCompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusCompanyService {

    private final BusCompanyRepository companyRepository;

    public BusCompanyResponseDto createCompany(BusCompanyRequestDto request) {
        BusCompanyEntity entity = request.toEntity();
        BusCompanyEntity saved = companyRepository.save(entity);
        return new BusCompanyResponseDto(saved);
    }

    public List<BusCompanyResponseDto> getAllCompanies() {
        return companyRepository.findAll()
                .stream()
                .map(BusCompanyResponseDto::new)
                .collect(Collectors.toList());
    }

    public BusCompanyResponseDto updateCompany(Integer id, BusCompanyRequestDto request) {
        BusCompanyEntity entity = companyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 회사가 존재하지 않습니다."));
        entity.update(request.getCompanyName());
        return new BusCompanyResponseDto(entity);
    }

    public void deleteCompany(Integer id) {
        companyRepository.deleteById(id);
    }
}
