package com.doongji.nestalk.service.chat;

import com.doongji.nestalk.controller.v1.chat.dto.RoomDto;
import com.doongji.nestalk.entity.chat.Participant;
import com.doongji.nestalk.entity.user.User;
import com.doongji.nestalk.error.NotFoundException;
import com.doongji.nestalk.repository.user.ProfileRepository;
import com.doongji.nestalk.repository.user.RoomRepository;
import com.doongji.nestalk.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChatService {
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    @Transactional
    public List<RoomDto> lookupMyChattingRoom(Long myId) {
        User me = userRepository.findById(myId)
                .orElseThrow(() -> new NotFoundException("해당 유저가 존재하지 않습니다"));

        return roomRepository.findByUser(me).stream()
                .map(room -> {
                    List<Participant> participants = room.getParticipantList();
                    return new RoomDto(room.getName(), participants, getProfileImageOfParticipants(participants), participants.size());
                })
                .collect(Collectors.toList());
    }

    private List<String> getProfileImageOfParticipants(List<Participant> participants) {

        return participants.stream()
                .map(participant -> userRepository.findById(participant.getParticipantId()).get())
                .map(user -> profileRepository.findByUser(user).get().getImageUrl())
                .collect(Collectors.toList());
    }
}
