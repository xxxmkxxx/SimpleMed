package com.xxxmkxxx.simplemed.features.user.models;

import com.xxxmkxxx.simplemed.features.security.models.RoleModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_credence")
public class UserCredenceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int credenceId;

    @Column(name = "login")
    private String login;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @OneToOne
    private UserModel user;

    @ManyToMany
    @JoinTable(
            name = "user_credence_role",
            joinColumns = @JoinColumn(name = "credence_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<RoleModel> userRoles;
}
