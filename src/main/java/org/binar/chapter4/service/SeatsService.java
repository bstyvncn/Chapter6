package org.binar.chapter4.service;

import org.binar.chapter4.model.seats;
import org.binar.chapter4.repositories.seatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SeatsService implements ISeatsService{

    @Autowired
    seatsRepository seatsRepository;
    @Override
    public List<seats> showSeats() {
        List<seats> s = seatsRepository.findSeatsByStatus();

        return s;
    }
}
