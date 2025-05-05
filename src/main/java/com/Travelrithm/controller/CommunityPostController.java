package com.Travelrithm.controller;

import com.Travelrithm.dto.CommunityPostRequestDto;
import com.Travelrithm.dto.CommunityPostResponseDto;
import com.Travelrithm.service.CommunityPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/community-posts")
@RequiredArgsConstructor
public class CommunityPostController {

    private final CommunityPostService postService;

    @PostMapping
    public CommunityPostResponseDto create(@RequestBody CommunityPostRequestDto request) {
        return postService.createPost(request);
    }

    @GetMapping
    public List<CommunityPostResponseDto> getAll() {
        return postService.getAllPosts();
    }

    @PutMapping("/{id}")
    public CommunityPostResponseDto update(@PathVariable Integer id, @RequestBody CommunityPostRequestDto request) {
        return postService.updatePost(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        postService.deletePost(id);
    }
}
