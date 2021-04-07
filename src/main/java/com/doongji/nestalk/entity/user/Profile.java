package com.doongji.nestalk.entity.user;

import com.doongji.nestalk.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@ToString(exclude = {"user"})
@Builder
public class Profile extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    private String stateMessage;

    private String imageUrl;

    private String backgroundUrl;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "profile")
    private User user;

    public Profile(Long profileId, String stateMessage, String imageUrl, String backgroundUrl) {
        this.profileId = profileId;
        this.stateMessage = stateMessage;
        this.imageUrl = imageUrl;
        this.backgroundUrl = backgroundUrl;
    }
}