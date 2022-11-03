package org.binar.chapter4.repositories;

import org.binar.chapter4.model.bookFilm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookFilmRepository extends JpaRepository<bookFilm, String> {
}
