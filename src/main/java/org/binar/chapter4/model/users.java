package org.binar.chapter4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class users {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "username")
    private String username;

    private String email;
    private String address;
    private String password;
}
