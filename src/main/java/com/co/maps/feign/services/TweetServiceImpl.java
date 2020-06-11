package com.co.maps.feign.services;

import com.co.maps.feign.repository.TweetRepository;
import com.co.maps.feign.domain.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetServiceImpl implements TweetService {

    private TweetRepository tweetRepository;

    @Autowired
    public TweetServiceImpl(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Override
    public Tweet save(Tweet tweet) {
        try {
            return tweetRepository.save(tweet);
        } catch (Exception ex) {
            throw new RuntimeException("Save Tweet failed", ex.getCause());
        }
    }

    @Override
    public List<Tweet> findByUserEmail(String email) {
        return tweetRepository.findByUser_Email(email);
    }


}
