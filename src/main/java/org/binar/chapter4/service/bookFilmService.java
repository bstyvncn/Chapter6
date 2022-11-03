package org.binar.chapter4.service;

import org.binar.chapter4.model.bookFilm;
import org.binar.chapter4.repositories.bookFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class bookFilmService implements IBookFilmService{
    @Autowired
    bookFilmRepository bookFilmRepository;

    @Override
    public void newBooking(bookFilm bookFilm) {
        bookFilmRepository.save(bookFilm);
    }
}
