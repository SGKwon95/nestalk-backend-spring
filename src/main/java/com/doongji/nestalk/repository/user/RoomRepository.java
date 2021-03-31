package com.doongji.nestalk.repository.user;

import com.doongji.nestalk.entity.chat.Room;
import com.doongji.nestalk.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
    List<Room> findByUser(User user);
}
