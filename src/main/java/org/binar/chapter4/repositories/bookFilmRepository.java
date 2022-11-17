package org.binar.chapter4.repositories;

import org.binar.chapter4.model.bookFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookFilmRepository extends JpaRepository<bookFilm, String> {
}
