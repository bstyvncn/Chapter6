package org.binar.chapter4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class seats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer seatsID;
    private String studioName;

    private String NomorKursi;
    private String status;

}
