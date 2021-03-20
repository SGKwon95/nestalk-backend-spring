package com.doongji.nestalk.repository.user;

import com.doongji.nestalk.entity.chat.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
}
