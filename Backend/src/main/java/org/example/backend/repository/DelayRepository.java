package org.example.backend.repository;

import org.example.backend.domain.Delay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DelayRepository extends JpaRepository<Delay, Integer> {
}