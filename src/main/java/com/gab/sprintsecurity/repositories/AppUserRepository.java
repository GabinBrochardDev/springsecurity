package com.gab.sprintsecurity.repositories;

import com.gab.sprintsecurity.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    public AppUser findByUsername(String username);

}
