package com.Travelrithm.dto;


import com.Travelrithm.domain.ScrapEntity;

public record ScrapDto(
        Integer scrapId,
        Integer userId,
        Integer postId

) {
    public ScrapDto(ScrapEntity scrapEntity){
        this(
             scrapEntity.getScrapId(),
             scrapEntity.getUserEntity().getUserId(),
             scrapEntity.getPostEntity().getPostId()
        );
    }
}
