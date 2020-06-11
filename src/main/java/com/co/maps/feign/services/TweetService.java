package com.co.maps.feign.services;

import com.co.maps.feign.domain.Tweet;

import java.util.List;

public interface TweetService {

    Tweet save(Tweet paragraph);

    List<Tweet> findByUserEmail(String email);

}
