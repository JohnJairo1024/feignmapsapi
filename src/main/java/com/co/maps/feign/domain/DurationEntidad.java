
package com.co.maps.feign.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "duration")
@Getter
@Setter
public class DurationEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "distanceId")
    private long durationId;

    @Column(name = "text")
    private String text;

    @Column(name = "value")
    private Integer value;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "google_id", nullable = false)
    private GoogleEntidad googleEntidad;

    public DurationEntidad() {
    }

    public DurationEntidad(String text, Integer value, GoogleEntidad googleEntidad) {
        this.text = text;
        this.value = value;
        this.googleEntidad = googleEntidad;
    }

}
