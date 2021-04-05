package com.doongji.nestalk.repository.user;

import com.doongji.nestalk.entity.user.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {
    List<Profile> findByUserIdIn(List<Long> userIdList);
}
