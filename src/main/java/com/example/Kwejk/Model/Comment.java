package com.example.Kwejk.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String commentByUser;
    private Integer points;


    @ManyToOne
    private File file;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


//    private time
//    private reply




}