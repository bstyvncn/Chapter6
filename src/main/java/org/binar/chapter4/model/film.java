package org.binar.chapter4.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer filmID;

    private String namaFilm;
    private String statusTayang;
}
