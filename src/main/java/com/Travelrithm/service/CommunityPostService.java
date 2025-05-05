package com.Travelrithm.service;

import com.Travelrithm.domain.CommunityPostEntity;
import com.Travelrithm.domain.PlanEntity;
import com.Travelrithm.domain.UserEntity;
import com.Travelrithm.dto.CommunityPostRequestDto;
import com.Travelrithm.dto.CommunityPostResponseDto;
import com.Travelrithm.repository.CommunityPostRepository;
import com.Travelrithm.repository.PlanRepository;
import com.Travelrithm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CommunityPostService {

    private final CommunityPostRepository postRepository;
    private final UserRepository userRepository;
    private final PlanRepository planRepository;

    public CommunityPostResponseDto createPost(CommunityPostRequestDto postRequestDto) {
        UserEntity userEntity = userRepository.findById(postRequestDto.userId())
                .orElseThrow(() -> new IllegalArgumentException("해당 유자가 존재하지 않습니다"));
        PlanEntity planEntity = planRepository.findById(postRequestDto.planId())
                .orElseThrow(() -> new IllegalArgumentException("해당 플랜이 존재하지 않습니다"));

        CommunityPostEntity postEntity = CommunityPostEntity.builder()
                .userEntity(userEntity)
                .planEntity(planEntity)
                .title(postRequestDto.title())
                .postContent(postRequestDto.postContent())
                .isTravelPlan(postRequestDto.isTravelPlan())
                .build();
        return new CommunityPostResponseDto(postRepository.save(postEntity));
    }
    @Transactional(readOnly = true)
    public List<CommunityPostResponseDto> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(CommunityPostResponseDto::new)
                .toList();
    }

    public CommunityPostResponseDto updatePost(Integer postId, CommunityPostRequestDto postRequestDto) {
        CommunityPostEntity postEntity = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        PlanEntity planEntity = planRepository.findById(postRequestDto.planId())
                .orElseThrow(() -> new IllegalArgumentException("해당 플랜이 존재하지 않음"));
        postEntity.update(postRequestDto,planEntity);

        return new CommunityPostResponseDto(postEntity);
    }

    public void deletePost(Integer postId) {
        postRepository.deleteById(postId);
    }
}
