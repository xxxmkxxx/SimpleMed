package com.xxxmkxxx.simplemed.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewModel {
    private int reviewId;
    private Date date;
    private UserModel userSender;
    private UserModel userRecipient;
    private String textReview;
}
