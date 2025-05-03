package com.Travelrithm.repository;

import com.Travelrithm.domain.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<LikeEntity, Integer> {

    List<LikeEntity> findByUserId(Integer userId);

    long countByPostId(Integer postId);

    long countByPlanId(Integer planId);

    Optional<LikeEntity> findByUserIdAndPostId(Integer userId, Integer postId);

    Optional<LikeEntity> findByUserIdAndPlanId(Integer userId, Integer planId);
}
