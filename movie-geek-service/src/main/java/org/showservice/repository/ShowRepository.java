package org.showservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.showservice.models.Show;

public interface ShowRepository extends JpaRepository<Show, Integer> {
}

