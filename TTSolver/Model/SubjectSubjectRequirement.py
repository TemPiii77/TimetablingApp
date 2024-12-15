class SubjectSubjectRequirement:
    def __init__(self, id: 'SubjectSubjectRequirementId', subject: 'Subject', subject_requirement: 'SubjectRequirement'):
        self.id = id
        self.subject = subject
        self.subject_requirement = subject_requirement

    def __str__(self):
        return f"SubjectSubjectRequirement(id={self.id}, subject={self.subject}, subject_requirement={self.subject_requirement})"
