package com.doongji.nestalk.entity.chat;

import com.doongji.nestalk.entity.BaseTimeEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@ToString(exclude = {"room","chat"})
@Builder
public class Participant extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long participant_id;

    @CreatedDate
    private LocalDateTime create_at;

    @LastModifiedDate
    private LocalDateTime modified_at;

    @ManyToOne
    private Room room;

    @ManyToOne
    private Chat chat;
}
