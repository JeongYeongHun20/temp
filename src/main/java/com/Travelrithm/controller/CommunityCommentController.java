package com.Travelrithm.controller;

import com.Travelrithm.dto.CommunityCommentRequestDto;
import com.Travelrithm.dto.CommunityCommentResponseDto;
import com.Travelrithm.security.jwt.CustomUserDetails;
import com.Travelrithm.service.CommunityCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/community-comments")
@RequiredArgsConstructor
public class CommunityCommentController {

    private final CommunityCommentService commentService;

    @PostMapping
    public CommunityCommentResponseDto create(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @RequestBody CommunityCommentRequestDto request) {
        Integer userId = userDetails.getUserId();
        request.setUserId(userId); //나중에 수정해야함
        return commentService.createComment(request);
    }

    @GetMapping("/post/{postId}")
    public List<CommunityCommentResponseDto> getByPost(@PathVariable Integer postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @PutMapping("/{id}")
    public CommunityCommentResponseDto update(@PathVariable Integer id, @RequestBody CommunityCommentRequestDto request) {
        return commentService.updateComment(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        commentService.deleteComment(id);
    }
}

