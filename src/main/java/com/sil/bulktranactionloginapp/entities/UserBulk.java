package com.sil.bulktranactionloginapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "USERSBULK")
@AllArgsConstructor
@NoArgsConstructor
public class UserBulk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;   // login username

    @Column(nullable = false)
    private String password;

    public UserBulk(String username, String password) {
        this.username = username;
        this.password = password;
    }
    // encrypted password
}
