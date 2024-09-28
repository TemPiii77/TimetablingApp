package org.example.backend.repository;

import org.example.backend.domain.SubjectRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRequirementRepository extends JpaRepository<SubjectRequirement, Integer> {
}