package com.doongji.nestalk.repository.user;

import com.doongji.nestalk.entity.chat.Chat;
import com.doongji.nestalk.entity.chat.Participant;
import com.doongji.nestalk.entity.chat.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    List<Room> findByRoom(Room room);
    List<Chat> findByChat(Chat chat);
}
