package com.co.maps.feign.repository;

import com.co.maps.feign.domain.GoogleEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoogleRepository extends JpaRepository<GoogleEntidad, Long> {

    GoogleEntidad findByOriginAddresses(String origen);

    GoogleEntidad findByDestinationAddresses(String destino);

//    @Query("SELECT g FROM GoogleEntidad g WHERE g.destinationAddresses = :destino AND g.originAddresses = :origen")
//   List<GoogleEntidad> findByDestinationAddressesAndOriginAddresses (@Param("destino") String destino, @Param("origen") String origen);

    /**
     * @param destino
     * @return
     */
    @Query(value = "SELECT * FROM GOOGLEMAPS \n" +
            "WHERE DESTINO = :destino AND ORIGEN = :origen", nativeQuery = true)
    List<GoogleEntidad> findByDestinoAndOrigen(@Param("destino") String destino, @Param("origen") String origen);

}
