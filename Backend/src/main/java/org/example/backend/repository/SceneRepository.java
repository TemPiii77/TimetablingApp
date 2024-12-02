package org.example.backend.repository;

import org.example.backend.domain.Scene;
import org.example.backend.dto.SceneDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.List;

@Repository
public interface SceneRepository extends JpaRepository<Scene, Integer> {
    List<Scene> findByNameContaining(String year);
}