package com.Travelrithm.repository;

import com.Travelrithm.domain.PlanEntity;
import com.Travelrithm.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanRepository extends JpaRepository<PlanEntity, Integer> {
    List<PlanEntity> findAllByUserEntity_UserId(Integer userId);

}
