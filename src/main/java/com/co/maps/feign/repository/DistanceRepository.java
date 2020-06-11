package com.co.maps.feign.repository;

import com.co.maps.feign.domain.DistanceEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistanceRepository extends JpaRepository<DistanceEntidad, Long> {

    List<DistanceEntidad> findById (long id);

}
