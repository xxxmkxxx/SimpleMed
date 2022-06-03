package com.xxxmkxxx.simplemed.features.social.models;

import com.xxxmkxxx.simplemed.features.user.models.UserModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "review")
public class ReviewModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @Column(name = "date_sending")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserModel sender;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private UserModel recipient;

    @Column(name = "text_review")
    private String textReview;
}
