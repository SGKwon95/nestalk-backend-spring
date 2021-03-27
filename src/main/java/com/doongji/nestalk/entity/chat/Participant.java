package com.doongji.nestalk.entity.chat;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"room","chat"})
@Builder
@Accessors(chain = true)
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long participant_id;

    private LocalDateTime create_at;

    private LocalDateTime modified_at;

    @ManyToOne
    private Room room;

    @ManyToOne
    private Chat chat;
}
