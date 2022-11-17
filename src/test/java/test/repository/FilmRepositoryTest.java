package test.repository;

import org.binar.chapter4.model.film;
import org.binar.chapter4.repositories.filmRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FilmRepositoryTest {
    filmRepository filmRepository;
    @Test
    void getUsersByUsername(){
        List<film> usersList = filmRepository.findFilmByStatusTayang();
    }
}
