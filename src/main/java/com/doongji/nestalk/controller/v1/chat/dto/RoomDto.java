package com.doongji.nestalk.controller.v1.chat.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class RoomDto {

    private String name;

    private List<String> profileImageUrlList;

    public RoomDto(String name, List<String> profileImageUrlList) {
        this.name = name;
        this.profileImageUrlList = profileImageUrlList;
    }
}
