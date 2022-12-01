package org.binar.chapter4.repositories;

import org.binar.chapter4.model.UserActive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActiveRepository extends JpaRepository<UserActive, Integer> {
}

