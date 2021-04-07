package com.doongji.nestalk.entity.chat;

import com.doongji.nestalk.entity.BaseTimeEntity;
import lombok.*;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@ToString(exclude = {"room"})
@Builder
public class Chat extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatId;

    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    public Chat(Long chatId, String message) {
        this.chatId = chatId;
        this.message = message;
    }

}
