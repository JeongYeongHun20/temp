package com.Travelrithm.controller;

import com.Travelrithm.dto.BusCompanyRequestDto;
import com.Travelrithm.dto.BusCompanyResponseDto;
import com.Travelrithm.service.BusCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus-companies")
@RequiredArgsConstructor
public class BusCompanyController {

    private final BusCompanyService busCompanyService;

    @PostMapping
    public BusCompanyResponseDto create(@RequestBody BusCompanyRequestDto request) {
        return busCompanyService.createCompany(request);
    }

    @GetMapping
    public List<BusCompanyResponseDto> getAll() {
        return busCompanyService.getAllCompanies();
    }

    @PutMapping("/{id}")
    public BusCompanyResponseDto update(@PathVariable Integer id, @RequestBody BusCompanyRequestDto request) {
        return busCompanyService.updateCompany(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        busCompanyService.deleteCompany(id);
    }
}
