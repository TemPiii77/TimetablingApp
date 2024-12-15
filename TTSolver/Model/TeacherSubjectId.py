class TeacherSubjectId:
    def __init__(self, teacher_id: str, subject_id: int):
        self.teacher_id = teacher_id
        self.subject_id = subject_id

    def __str__(self):
        return f"TeacherSubjectId(teacher_id={self.teacher_id}, subject_id={self.subject_id})"
