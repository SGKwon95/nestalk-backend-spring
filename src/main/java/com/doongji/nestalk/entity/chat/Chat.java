package com.doongji.nestalk.entity.chat;

import com.doongji.nestalk.entity.BaseTimeEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@ToString(exclude = {"room"})
@Builder
public class Chat extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chat_id;

    private String message;

    @CreatedDate
    private LocalDateTime create_at;

    @LastModifiedDate
    private LocalDateTime modified_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @Join
    private Room room;

}
