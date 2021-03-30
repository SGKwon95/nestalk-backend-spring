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
@NoArgsConstructor
@ToString(exclude = {"user"})
@Builder
public class Room extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long room_id;

    private String name;

    @CreatedDate
    private LocalDateTime create_at;

    @LastModifiedDate
    private LocalDateTime modified_at;

    private String chatRoom_type;

    @ManyToOne
    private User user;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "room")
    private List<Participant> participantList;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "room")
    private List<Chat> chatList;
}
