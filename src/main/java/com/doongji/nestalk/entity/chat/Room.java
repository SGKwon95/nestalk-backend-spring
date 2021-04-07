package com.doongji.nestalk.entity.chat;

import com.doongji.nestalk.entity.BaseTimeEntity;
import com.doongji.nestalk.entity.user.User;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@ToString(exclude = {"user"})
@Builder
public class Room extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    private String name;

    private String chatRoomType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "room")
    private List<Participant> participantList;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "room")
    private List<Chat> chatList;

    public Room(Long roomId, String name, String chatRoomType) {
        this.roomId = roomId;
        this.name = name;
        this.chatRoomType = chatRoomType;
    }

}
