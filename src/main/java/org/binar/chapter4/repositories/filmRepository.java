package org.binar.chapter4.repositories;

import org.binar.chapter4.model.film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface filmRepository extends JpaRepository<film, String> {

    @Query(value = "DELETE FROM film WHERE namaFilm = :namaFilm;", nativeQuery = true)
    public void deleteFilm(@Param("namaFilm") String namaFilm);

    @Query(value = "SELECT f FROM Film f WHERE STATUS_TAYANG = 'Tayang'")
    public List<film> findFilmByStatusTayang();

    @Modifying
    @Procedure("change_film_name")
    public void changeFilmName(String nameFrom, String nameTo);

}