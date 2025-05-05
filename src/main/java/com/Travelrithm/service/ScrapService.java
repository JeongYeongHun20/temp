package com.Travelrithm.service;

import com.Travelrithm.domain.PlanEntity;
import com.Travelrithm.domain.PostEntity;
import com.Travelrithm.domain.ScrapEntity;
import com.Travelrithm.domain.UserEntity;
import com.Travelrithm.repository.PlanRepository;
import com.Travelrithm.repository.PostRepository;
import com.Travelrithm.repository.ScrapRepository;
import com.Travelrithm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class ScrapService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final ScrapRepository scrapRepository;

    public void createScrap(Integer userId, Integer postId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유저 존재하지 않음"));
        PostEntity postEntity = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시물 존재하지 않음"));
        ScrapEntity scrapEntity = ScrapEntity.builder()
                .userEntity(userEntity)
                .postEntity(postEntity)
                .createdAt(LocalDateTime.now())
                .build();

        scrapRepository.save(scrapEntity);
    }
    public void removeScrap(Integer userId, Integer postId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유저 존재하지 않음"));
        PostEntity postEntity = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시물 존재하지 않음"));
        ScrapEntity scrap = scrapRepository.findByUserEntityAndPostEntity(userEntity,postEntity);
        scrapRepository.delete(scrap);
    }



}
