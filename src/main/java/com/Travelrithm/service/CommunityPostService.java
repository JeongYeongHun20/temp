package com.Travelrithm.service;

import com.Travelrithm.domain.CommunityPostEntity;
import com.Travelrithm.dto.CommunityPostRequestDto;
import com.Travelrithm.dto.CommunityPostResponseDto;
import com.Travelrithm.repository.CommunityPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommunityPostService {

    private final CommunityPostRepository postRepository;

    public CommunityPostResponseDto createPost(CommunityPostRequestDto request) {
        CommunityPostEntity entity = request.toEntity();
        return new CommunityPostResponseDto(postRepository.save(entity));
    }

    public List<CommunityPostResponseDto> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(CommunityPostResponseDto::new)
                .collect(Collectors.toList());
    }

    public CommunityPostResponseDto updatePost(Integer id, CommunityPostRequestDto request) {
        CommunityPostEntity entity = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        entity.update(request.getTitle(), request.getPostContent(), request.getIsTravelPlan(), request.getPlanId());
        return new CommunityPostResponseDto(entity);
    }

    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }
}
