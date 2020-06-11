package com.co.maps.feign.repository;

import com.co.maps.feign.domain.GoogleEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoogleRepository extends JpaRepository<GoogleEntidad, Long> {

}
