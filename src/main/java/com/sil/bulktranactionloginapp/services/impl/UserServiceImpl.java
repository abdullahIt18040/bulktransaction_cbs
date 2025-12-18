package com.sil.bulktranactionloginapp.services.impl;

import com.sil.bulktranactionloginapp.entities.UserBulk;
import com.sil.bulktranactionloginapp.repositors.UserRepo;
import com.sil.bulktranactionloginapp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo repo;


    @Override
    public UserBulk login(String email, String password) {
        UserBulk user =new UserBulk("abc@gmail.com","sdsa");
        UserBulk user2 = repo.findByUsername(email);
        if (user == null) return null;


        return user;
    }
}
