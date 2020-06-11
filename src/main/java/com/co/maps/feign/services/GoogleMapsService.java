package com.co.maps.feign.services;

import com.co.maps.feign.domain.GoogleEntidad;
import com.co.maps.feign.dto.GoogleMaps;

import java.util.List;

public interface GoogleMapsService {

    List<GoogleMaps> findAll();
    GoogleEntidad findById(long id);
}
