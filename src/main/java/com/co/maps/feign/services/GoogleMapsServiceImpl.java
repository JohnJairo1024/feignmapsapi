package com.co.maps.feign.services;

import com.co.maps.feign.domain.DistanceEntidad;
import com.co.maps.feign.domain.DurationEntidad;
import com.co.maps.feign.domain.GoogleEntidad;
import com.co.maps.feign.dto.*;
import com.co.maps.feign.repository.DistanceRepository;
import com.co.maps.feign.repository.DurationRepository;
import com.co.maps.feign.repository.GoogleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GoogleMapsServiceImpl implements GoogleMapsService {

    private GoogleRepository googleRepository;
    private DistanceRepository distanceRepository;
    private DurationRepository durationRepository;

    public GoogleMapsServiceImpl(
            GoogleRepository googleRepository,
            DistanceRepository distanceRepository,
            DurationRepository durationRepository
    ) {
        this.googleRepository = googleRepository;
        this.distanceRepository = distanceRepository;
        this.durationRepository = durationRepository;
    }

    @Override
    public List<GoogleMaps> findAll() {
        List<GoogleEntidad> lista = googleRepository.findAll();
        return getGoogleMaps(lista);
    }

    @Override
    public GoogleEntidad findById(long id) {
        GoogleEntidad findById = googleRepository.findById(id).orElseGet(null);
        return findById;
    }

    @Override
    public List<GoogleMaps> findByOrigenDestino(String destino, String origen) {
        List<GoogleEntidad> findByDestinoAndOrigen = googleRepository.findByDestinoAndOrigen(destino, origen);
        return getGoogleMaps(findByDestinoAndOrigen);
    }

    /**
     *
     * @param findByDestinoAndOrigen
     * @return
     */
    private List<GoogleMaps> getGoogleMaps(List<GoogleEntidad> findByDestinoAndOrigen) {
        List<GoogleMaps> listaDTO = new ArrayList<>();
        for (GoogleEntidad googleEntidad : findByDestinoAndOrigen) {
            GoogleMaps googleMaps = new GoogleMaps();
            googleMaps.setDestinationAddresses(Collections.singletonList(googleEntidad.getDestinationAddresses()));
            googleMaps.setOriginAddresses(Collections.singletonList(googleEntidad.getOriginAddresses()));

            //lista de elementos
            Element element = new Element();

            //lista de distancia
            List<DistanceEntidad> distanceEntidad = distanceRepository.findById(googleEntidad.getGoogleId());
            List<Distance> distances = new ArrayList<>();
            if (distanceEntidad != null && !distanceEntidad.isEmpty()) {
                distanceEntidad.stream().map((fila) -> {
                    Distance distance = new Distance();
                    distance.setText(fila.getText());
                    distance.setValue(fila.getValue());
                    return distance;
                }).forEachOrdered((distance) -> distances.add(distance));
            }

            // recorre la distancia
            for (Distance distance : distances) {
                distance.setText(distance.getText());
                distance.setValue(distance.getValue());
                element.setDistance(distance);
            }

            //lista de duracion
            List<DurationEntidad> durationEntidad = durationRepository.findById(googleEntidad.getGoogleId());
            List<Duration> durations = new ArrayList<>();
            if (durationEntidad != null && !durationEntidad.isEmpty()) {
                durationEntidad.stream().map((fila) -> {
                    Duration duration = new Duration();
                    duration.setText(fila.getText());
                    duration.setValue(fila.getValue());
                    return duration;
                }).forEachOrdered((duration) -> durations.add(duration));
            }

            // recorre la duracion
            for (Duration duration : durations) {
                duration.setText(duration.getText());
                duration.setValue(duration.getValue());
                element.setDuration(duration);
            }
            element.setStatus("OK");

            Row row = new Row();
            row.setElements(Collections.singletonList(element));
            googleMaps.setRows(Collections.singletonList(row));
            googleMaps.setStatus("OK");

            listaDTO.add(googleMaps);

        }
        return listaDTO;
    }

}
