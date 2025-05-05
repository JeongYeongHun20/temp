package com.Travelrithm.service;

import com.Travelrithm.domain.LikeEntity;
import com.Travelrithm.dto.LikeRequestDto;
import com.Travelrithm.dto.LikeResponseDto;
import com.Travelrithm.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;

    public LikeResponseDto addLike(LikeRequestDto request) {
        return new LikeResponseDto(likeRepository.save(request.toEntity()));
    }

    public void removeLike(Integer likeId) {
        likeRepository.deleteById(likeId);
    }

    public List<LikeResponseDto> getLikesByUser(Integer userId) {
        return likeRepository.findByUserId(userId)
                .stream()
                .map(LikeResponseDto::new)
                .collect(Collectors.toList());
    }

    public long countLikesForPost(Integer postId) {
        return likeRepository.countByPostId(postId);
    }

    public long countLikesForPlan(Integer planId) {
        return likeRepository.countByPlanId(planId);
    }

    public boolean existsByUserAndPost(Integer userId, Integer postId) {
        return likeRepository.findByUserIdAndPostId(userId, postId).isPresent();
    }

    public boolean existsByUserAndPlan(Integer userId, Integer planId) {
        return likeRepository.findByUserIdAndPlanId(userId, planId).isPresent();
    }
}
