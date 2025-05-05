package com.Travelrithm.service;

import com.Travelrithm.domain.CommunityCommentEntity;
import com.Travelrithm.dto.CommunityCommentRequestDto;
import com.Travelrithm.dto.CommunityCommentResponseDto;
import com.Travelrithm.repository.CommunityCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CommunityCommentService {

    private final CommunityCommentRepository commentRepository;

    public CommunityCommentResponseDto createComment(CommunityCommentRequestDto request) {
        CommunityCommentEntity entity = request.toEntity();
        return new CommunityCommentResponseDto(commentRepository.save(entity));
    }

    public List<CommunityCommentResponseDto> getCommentsByPostId(Integer postId) {
        return commentRepository.findByPostId(postId)
                .stream()
                .map(CommunityCommentResponseDto::new)
                .collect(Collectors.toList());
    }

    public CommunityCommentResponseDto updateComment(Integer postId, CommunityCommentRequestDto request) {
        CommunityCommentEntity entity = commentRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));
        entity.update(request.getCommentContent());
        return new CommunityCommentResponseDto(entity);
    }

    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }
}
