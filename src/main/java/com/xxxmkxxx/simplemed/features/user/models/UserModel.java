package com.xxxmkxxx.simplemed.features.user.models;

import com.xxxmkxxx.simplemed.features.social.models.ReviewModel;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sender")
    private List<ReviewModel> sentReviews;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipient")
    private List<ReviewModel> recipientReviews;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private PatientModel patient;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private PatientModel medic;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private UserCredenceModel credence;
}
