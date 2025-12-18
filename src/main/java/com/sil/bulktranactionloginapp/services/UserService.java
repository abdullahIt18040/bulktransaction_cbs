package com.sil.bulktranactionloginapp.services;


import com.sil.bulktranactionloginapp.entities.UserBulk;

public interface UserService {
    UserBulk login(String email, String password);
}
