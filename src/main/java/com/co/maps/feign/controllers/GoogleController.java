package com.co.maps.feign.controllers;


import com.co.maps.feign.domain.GoogleEntidad;
import com.co.maps.feign.dto.DestinoOrigen;
import com.co.maps.feign.dto.GoogleMaps;
import com.co.maps.feign.services.GoogleMapsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maps.googleapis.com")
public class GoogleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleController.class);

    @Autowired
    private GoogleMapsService googleMapsService;

    @GetMapping("/mapsall")
    public ResponseEntity<List<GoogleMaps>> getAll() {
        List<GoogleMaps> googleEntidads = googleMapsService.findAll();
        return ResponseEntity.ok(googleEntidads);
    }

    @GetMapping("/maps/{id}")
    public ResponseEntity<GoogleEntidad> getById(@PathVariable(value = "id") long id) {
        GoogleEntidad googleMapsServiceById = googleMapsService.findById(id);
        if (googleMapsServiceById != null) {
            return ResponseEntity.ok(googleMapsServiceById);
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/maps")
    public ResponseEntity<List<GoogleMaps>> getByDistanceDuration(
            @RequestParam String destino,
            @RequestParam String origen
    ) {
        List<GoogleMaps> findByoriginAddresses = googleMapsService.findByOrigenDestino(destino, origen);
        if (findByoriginAddresses != null) {
            return ResponseEntity.ok(findByoriginAddresses);
        }
        return ResponseEntity.notFound().build();
    }

}
