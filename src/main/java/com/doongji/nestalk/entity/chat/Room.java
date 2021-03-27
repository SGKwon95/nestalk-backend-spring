package com.doongji.nestalk.entity.chat;

import com.doongji.nestalk.entity.user.User;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"user"})
@Builder
@Accessors(chain = true)
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long room_id;

    private String name;

    private LocalDateTime create_at;

    private LocalDateTime modified_at;

    private String chatRoom_type;

    @ManyToOne
    private User user;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "room")
    private List<Participant> participantList;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "room")
    private List<Chat> chatList;
}
