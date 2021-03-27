package com.doongji.nestalk.entity.chat;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"room"})
@Builder
@Accessors(chain = true)
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chat_id;

    private String message;

    private LocalDateTime create_at;

    private LocalDateTime modified_at;

    @ManyToOne
    private Room room;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "chat")
    private List<Participant> participantList;
}
