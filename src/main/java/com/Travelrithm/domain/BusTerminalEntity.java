package com.Travelrithm.domain;

import com.Travelrithm.dto.BusTerminalRequestDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bus_terminal")
public class BusTerminalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer terminalId;

    private String name;
    private String city;
    private String address;

    @Column(precision = 10, scale = 8)
    private Double lat;

    @Column(precision = 11, scale = 8)
    private Double lng;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public void update(BusTerminalRequestDto dto) {
        this.name = dto.getName();
        this.city = dto.getCity();
        this.address = dto.getAddress();
        this.lat = dto.getLat();
        this.lng = dto.getLng();
    }
}



