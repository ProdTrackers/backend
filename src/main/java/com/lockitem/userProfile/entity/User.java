package com.lockitem.userProfile.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Setter
    @Column(name = "last_name")
    private String lastName;
    @Setter
    private String email;
    @Setter
    private String password;
}
