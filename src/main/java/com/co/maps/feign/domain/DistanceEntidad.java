
package com.co.maps.feign.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "distance")
@Getter
@Setter
public class DistanceEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "distanceId")
    private long distanceId;

    @Column(name = "text")
    private String text;

    @Column(name = "value")
    private Integer value;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "google_id", nullable = false)
    private GoogleEntidad googleEntidad;

    public DistanceEntidad() {
    }

    public DistanceEntidad(String text, Integer value, GoogleEntidad googleEntidad) {
        this.text = text;
        this.value = value;
        this.googleEntidad = googleEntidad;
    }

}
