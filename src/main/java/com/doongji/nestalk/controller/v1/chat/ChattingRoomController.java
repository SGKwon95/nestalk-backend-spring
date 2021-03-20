package com.doongji.nestalk.controller.v1.chat;

import com.doongji.nestalk.entity.chat.Room;
import com.doongji.nestalk.repository.user.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ChattingRoomController {

    private final RoomRepository roomRepository;

    @GetMapping("/api/chat/lookup")
    public List<Room> lookupChattingRoom() {

        return roomRepository.findAll();
    }
}
