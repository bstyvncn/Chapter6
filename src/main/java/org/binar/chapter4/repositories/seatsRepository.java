package org.binar.chapter4.repositories;

import org.binar.chapter4.model.seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface seatsRepository extends JpaRepository<seats, String> {
    @Query(value = "SELECT s FROM seats s WHERE status = 'Available'")
    public List<seats> findSeatsByStatus();
}
