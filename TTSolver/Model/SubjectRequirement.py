class SubjectRequirement:
    def __init__(self, id: int, field: str, grade: int, period: int, advanced: bool):
        self.id = id
        self.field = field
        self.grade = grade
        self.period = period
        self.advanced = advanced

    def __str__(self):
        return f"SubjectRequirement(id={self.id}, field={self.field}, grade={self.grade}, period={self.period}, advanced={self.advanced})"
