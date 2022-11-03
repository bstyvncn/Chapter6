package org.binar.chapter4.repositories;
import org.binar.chapter4.model.schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface scheduleRepository extends JpaRepository<schedule, String> {
    @Query(value = "select * from schedule where filmID = :filmID", nativeQuery = true)
    public List<schedule> viewScheduleByFilm(@Param("filmID") int filmID);

}
