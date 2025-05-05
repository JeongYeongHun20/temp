package com.Travelrithm.controller;

import com.Travelrithm.dto.LikeRequestDto;
import com.Travelrithm.dto.LikeResponseDto;
import com.Travelrithm.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping
    public LikeResponseDto addLike(@RequestBody LikeRequestDto request) {
        return likeService.addLike(request);
    }

    @DeleteMapping("/{likeId}")
    public void deleteLike(@PathVariable Integer likeId) {
        likeService.removeLike(likeId);
    }

    @GetMapping("/user/{userId}")
    public List<LikeResponseDto> getLikesByUser(@PathVariable Integer userId) {
        return likeService.getLikesByUser(userId);
    }

    @GetMapping("/count/post/{postId}") // 게시글 좋아요 개수
    public long countLikesForPost(@PathVariable Integer postId) {
        return likeService.countLikesForPost(postId);
    }

    @GetMapping("/count/plan/{planId}") // 플랜 좋아요 개수
    public long countLikesForPlan(@PathVariable Integer planId) {
        return likeService.countLikesForPlan(planId);
    }

}
