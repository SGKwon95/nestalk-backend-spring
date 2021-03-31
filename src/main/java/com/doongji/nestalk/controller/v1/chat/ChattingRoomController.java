package com.doongji.nestalk.controller.v1.chat;

import com.doongji.nestalk.entity.chat.Room;
import com.doongji.nestalk.error.NotFoundException;
import com.doongji.nestalk.repository.user.RoomRepository;
import com.doongji.nestalk.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ChattingRoomController {

    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    @GetMapping("/api/chat/lookup/all")
    public List<Room> lookupChattingRoomAll() {

        return roomRepository.findAll();
    }

    @ExceptionHandler
    public ResponseEntity<String> NotFoundExceptionHandler(NotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    }

    @GetMapping("/api/chat/lookup/{id}")
    public List<Room> lookupChattingRoomByUserId(@PathVariable Long userId) {

        return userRepository.findById(userId)
                .map(user -> roomRepository.findByUser(user))
                .orElseThrow(()->new NotFoundException("조회한 유저의 채팅이 없습니다"));
    }
}
