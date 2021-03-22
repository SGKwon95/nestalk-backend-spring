package com.doongji.nestalk.controller.chat;

import com.doongji.nestalk.entity.chat.Room;
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

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class ChattingRoomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RoomRepository roomRepository;

    @Test
    @Transactional
    public void lookupChattingRoom() throws Exception {
        roomRepository.save(Room.builder().room_pk(1L).room_name("First Room").build());
        roomRepository.save(Room.builder().room_pk(2L).room_name("Second Room").build());

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/chat/lookup")
                .header("x-access-token", "Bearer "+System.getenv("TOKEN")))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("[{\"room_pk\":1,\"room_name\":\"First Room\"},{\"room_pk\":2,\"room_name\":\"Second Room\"}]"))
                .andDo(MockMvcResultHandlers.print());
    }
}
