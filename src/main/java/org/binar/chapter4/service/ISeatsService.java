package org.binar.chapter4.service;

import org.binar.chapter4.model.seats;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ISeatsService {

    List<seats> showSeats();
}
