package com.co.maps.feign.repository;

import com.co.maps.feign.domain.DurationEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DurationRepository extends JpaRepository<DurationEntidad, Long> {

    List<DurationEntidad> findById (long id);

}
