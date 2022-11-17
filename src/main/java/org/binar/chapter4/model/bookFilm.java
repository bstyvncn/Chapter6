package org.binar.chapter4.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class bookFilm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ticketID;

    @OneToOne
    private users user;

    @ManyToOne
    private seats seats;

    @OneToOne
    private schedule schedule;
}
