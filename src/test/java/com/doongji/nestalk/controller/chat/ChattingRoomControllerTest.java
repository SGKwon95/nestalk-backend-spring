package com.doongji.nestalk.controller.chat;

import com.doongji.nestalk.entity.chat.Chat;
import com.doongji.nestalk.entity.chat.Participant;
import com.doongji.nestalk.entity.chat.Room;
import com.doongji.nestalk.repository.user.ChatRepository;
import com.doongji.nestalk.repository.user.ParticipantRepository;
import com.doongji.nestalk.repository.user.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class ChattingRoomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Test
    @Transactional
    public void lookupChattingRoom() throws Exception {
/*
        roomRepository.save(Room.builder().roomId(1L).name("First Room").createAt(LocalDateTime.now()).modifiedAt(null).chatRoomType("A").build());
        roomRepository.save(Room.builder().roomId(2L).name("Second Room").createAt(LocalDateTime.now()).modifiedAt(null).chatRoomType("A").build());
        chatRepository.save(Chat.builder().chatId(1L).message("ㅎㅇ").createAt(LocalDateTime.now()).modifiedAt(null).build());
        chatRepository.save(Chat.builder().chatId(2L).message("ㅇㅇ").createAt(LocalDateTime.now()).modifiedAt(null).build());
        participantRepository.save(Participant.builder().participantId(1L).createAt(LocalDateTime.now()).modifiedAt(null).build());
        participantRepository.save(Participant.builder().participantId(2L).createAt(LocalDateTime.now()).modifiedAt(null).build());
*/

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/chat/lookup")
                .header("x-access-token", "Bearer "+System.getenv("TOKEN")))
                .andExpect(MockMvcResultMatchers.status().isOk())
                //andExpect(MockMvcResultMatchers.content().string("[{\"room_pk\":1,\"room_name\":\"First Room\"},{\"room_pk\":2,\"room_name\":\"Second Room\"}]"))
                .andDo(MockMvcResultHandlers.print());
    }
}
