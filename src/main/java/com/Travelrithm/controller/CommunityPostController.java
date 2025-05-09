package com.Travelrithm.controller;

import com.Travelrithm.dto.CommunityPostRequestDto;
import com.Travelrithm.dto.CommunityPostResponseDto;
import com.Travelrithm.dto.ScrapDto;
import com.Travelrithm.security.jwt.CustomUserDetails;
import com.Travelrithm.service.CommunityPostService;
import com.Travelrithm.service.ScrapService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class CommunityPostController {

    private final CommunityPostService postService;
    private final ScrapService scrapService;

    @PostMapping
    public CommunityPostResponseDto createPost(@RequestBody CommunityPostRequestDto request) {
        return postService.createPost(request);
    }

    @GetMapping
    public List<CommunityPostResponseDto> getPosts() {
        return postService.getAllPosts();
    }

    @PutMapping("/{postId}")
    public CommunityPostResponseDto update(@PathVariable Integer postId, @RequestBody CommunityPostRequestDto postRequestDto) {
        return postService.updatePost(postId, postRequestDto);
    }

    @DeleteMapping("/{postId}")
    public void delete(@PathVariable Integer postId) {
        postService.deletePost(postId);
    }

    @GetMapping("/{postId}/scrap")
    public ScrapDto toggleScrap(@AuthenticationPrincipal CustomUserDetails userDetails, @PathVariable(name = "postId") Integer postId) {
        Integer userId=userDetails.getUserId();
        return scrapService.createScrap(userId, postId);

    }
    @DeleteMapping("/{postId}/scrap")
    public ResponseEntity<Void> untoggleScrap(@AuthenticationPrincipal CustomUserDetails userDetails, @PathVariable(name = "postId") Integer postId) {
        Integer userId=userDetails.getUserId();
        scrapService.removeScrap(userId,postId);

        return ResponseEntity.noContent().build();

    }
}
