package com.co.maps.feign.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "googlemaps")
@Getter
@Setter
public class GoogleEntidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "googleId")
    private long googleId;

    @Column(name = "destino")
    private String destinationAddresses;

    @Column(name = "origen")
    private String originAddresses;

    @OneToMany(mappedBy = "googleEntidad", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<DistanceEntidad> distanceE;

    @OneToMany(mappedBy = "googleEntidad", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<DurationEntidad> durationE;

    public GoogleEntidad() {
    }

    public GoogleEntidad(String destinationAddresses, String originAddresses) {
        this.destinationAddresses = destinationAddresses;
        this.originAddresses = originAddresses;
    }



    //    @JsonIgnore
    //    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    //    private Set<Tweet> tweets = new HashSet<>();

}
