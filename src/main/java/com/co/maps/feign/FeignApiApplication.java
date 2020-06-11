package com.co.maps.feign;

import com.co.maps.feign.domain.DistanceEntidad;
import com.co.maps.feign.domain.DurationEntidad;
import com.co.maps.feign.domain.GoogleEntidad;
import com.co.maps.feign.domain.User;
import com.co.maps.feign.repository.DistanceRepository;
import com.co.maps.feign.repository.DurationRepository;
import com.co.maps.feign.repository.GoogleRepository;
import com.co.maps.feign.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FeignApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner mappingDemo(
            UserRepository userRepository,
            GoogleRepository googleRepository,
            DistanceRepository distanceRepository,
            DurationRepository durationRepository
    ) {
        return args -> {

            // create a new User
            User user = new User("John","Ochoa","john.ochoa","john@gmail.com","123456");
            userRepository.save(user);

            // create a new GoogleEntidad 1
            GoogleEntidad googleEntidad1 = new GoogleEntidad("New York, NY, USA", "Washington, DC, USA");
            googleRepository.save(googleEntidad1);
            distanceRepository.save(new DistanceEntidad("225 mi", 361715, googleEntidad1));
            durationRepository.save(new DurationEntidad("3 hours 49 mins", 13725, googleEntidad1));

            // create a new GoogleEntidad 2
            GoogleEntidad googleEntidad2 = new GoogleEntidad("New York, NY, USA2", "Washington, DC, USA2");
            googleRepository.save(googleEntidad2);
            distanceRepository.save(new DistanceEntidad("226 mi", 361716, googleEntidad2));
            durationRepository.save(new DurationEntidad("4 hours 50 mins", 13726, googleEntidad2));
        };
    }

}
