package org.binar.chapter4.service;

import org.binar.chapter4.model.bookFilm;
import org.springframework.stereotype.Service;

@Service
public interface IBookFilmService {
    void newBooking(bookFilm bookFilm);
}
