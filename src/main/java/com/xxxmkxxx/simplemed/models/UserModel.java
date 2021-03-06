package com.xxxmkxxx.simplemed.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userId;

    @Column(name = "login")
    private String login;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "phone")
    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sender")
    private List<ReviewModel> sentReviews;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipient")
    private List<ReviewModel> recipientReviews;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<RoleModel> userRoles;
}
