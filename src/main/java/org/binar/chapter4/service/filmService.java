package org.binar.chapter4.service;

import org.binar.chapter4.model.film;
import org.binar.chapter4.repositories.filmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class filmService implements IFilmService{

    @Autowired
    filmRepository filmRepository;
    @Override
    public void newFilm(film film) {
        filmRepository.save(film);
    }

    @Override
    public List<film> showFilm(){
        List<film> films = filmRepository.findFilmByStatusTayang();

        return films;
    }

    @Override
    public void deleteFilm(film film) {
        filmRepository.deleteFilm(film.getNamaFilm());
    }

    @Override
    public void updateFilm(String from, String to) {
        filmRepository.changeFilmName(from, to);
    }
}

//    1. Menambahkan film baru
//            2. Mengupdate nama file
//            3. Menghapus film
//            4. Menampilkan film yang sedang tayang
