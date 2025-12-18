package com.sil.bulktranactionloginapp.repositors;

import com.sil.bulktranactionloginapp.entities.UserBulk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserBulk, Long> {
    UserBulk findByUsername(String email);

}