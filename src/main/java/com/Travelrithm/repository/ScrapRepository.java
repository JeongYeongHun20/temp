package com.Travelrithm.repository;


import com.Travelrithm.domain.CommunityPostEntity;
import com.Travelrithm.domain.ScrapEntity;
import com.Travelrithm.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScrapRepository extends JpaRepository<ScrapEntity, Integer> {
    ScrapEntity findByUserEntityAndPostEntity(UserEntity userEntity, CommunityPostEntity postEntity);
}