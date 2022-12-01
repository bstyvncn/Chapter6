package org.binar.chapter4.repositories;

import org.binar.chapter4.model.ENumeration.ERoles;
import org.binar.chapter4.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERoles name);
}

