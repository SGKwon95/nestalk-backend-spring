package com.doongji.nestalk.controller.v1.chat.dto;

import com.doongji.nestalk.entity.chat.Participant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class RoomDto {

    private String name;

    private List<Participant> participantList;

    private List<String> profileImageUrlList;

    private int userCnt;

    public RoomDto(String name, List<Participant> participantList, List<String> profileImageUrlList, int userCnt) {
        this.name = name;
        this.participantList = participantList;
        this.profileImageUrlList = profileImageUrlList;
        this.userCnt = userCnt;
    }
}
