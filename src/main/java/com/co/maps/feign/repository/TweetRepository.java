package com.co.maps.feign.repository;

import com.co.maps.feign.domain.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findByUser_Email(String email);

}
