package com.jonghak.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.jonghak.board.entity.primaryKey.LikeyPK;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Likey")
@Table(name = "Likey")
@IdClass(LikeyPK.class)
public class LikeyEntity {
    @Id
    private int boardNumber;
    @Id
    private String userEmail;
    private String userNickname;
    private String userProfileImageUrl;
}
