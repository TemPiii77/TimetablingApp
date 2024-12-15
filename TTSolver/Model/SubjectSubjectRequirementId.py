class SubjectSubjectRequirementId:
    def __init__(self, subject_id: int, subject_requirement_id: int):
        self.subject_id = subject_id
        self.subject_requirement_id = subject_requirement_id

    def __str__(self):
        return f"SubjectSubjectRequirementId(subject_id={self.subject_id}, subject_requirement_id={self.subject_requirement_id})"
