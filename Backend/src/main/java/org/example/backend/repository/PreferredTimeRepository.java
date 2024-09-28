package org.example.backend.repository;

import org.example.backend.domain.PreferredTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferredTimeRepository extends JpaRepository<PreferredTime, Integer> {
}