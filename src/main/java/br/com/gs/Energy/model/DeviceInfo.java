package br.com.gs.Energy.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "deviceInfo")
@Getter@Setter
@NoArgsConstructor
public class DeviceInfo {
    @Id
    @GeneratedValue
    private Integer id;
    @Column( name = "voltage",nullable = false)
    private Float voltage;
    @Column(name = "energyLevel")
    private double energyLevel;

    // Relacionamento ManyToOne, pois cada DeviceInfo pertence a um único Device
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    private Device device;
}
