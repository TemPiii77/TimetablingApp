package org.example.backend.repository;

import org.example.backend.domain.SubjectSubjectRequirement;
import org.example.backend.domain.SubjectSubjectRequirementId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectSubjectRequirementRepository extends JpaRepository<SubjectSubjectRequirement, SubjectSubjectRequirementId> {
}