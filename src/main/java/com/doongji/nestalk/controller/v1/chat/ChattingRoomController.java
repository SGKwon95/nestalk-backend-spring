package com.doongji.nestalk.controller.v1.chat;

import com.doongji.nestalk.controller.v1.chat.dto.RoomDto;
import com.doongji.nestalk.entity.chat.Room;
import com.doongji.nestalk.entity.user.User;
import com.doongji.nestalk.error.NotFoundException;
import com.doongji.nestalk.repository.user.ProfileRepository;
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
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class ChattingRoomController {

    private final RoomRepository roomRepository;
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    @ExceptionHandler
    public ResponseEntity<String> NotFoundExceptionHandler(NotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    }

    @GetMapping("/api/chat/lookup/{id}")
    public List<RoomDto> lookupMyChattingRoom(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("해당 유저가 존재하지 않습니다"));

        return roomRepository.findByUser(user).stream()
                .map(room -> new RoomDto(room.getName(),getProfileImageOfParticipants(room)))
                .collect(Collectors.toList());
    }

    private List<String> getProfileImageOfParticipants(Room room) {

        return room.getParticipantList().stream()
                .map(participant -> userRepository.findById(participant.getParticipantId()).get())
                .map(user -> profileRepository.findByUser(user).get().getImageUrl())
                .collect(Collectors.toList());
    }
}
