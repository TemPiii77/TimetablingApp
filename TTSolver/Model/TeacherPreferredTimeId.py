class TeacherPreferredTimeId:
    def __init__(self, teacher_id: str, preferred_time_id: int):
        self.teacher_id = teacher_id
        self.preferred_time_id = preferred_time_id

    def __str__(self):
        return f"TeacherPreferredTimeId(teacher_id={self.teacher_id}, preferred_time_id={self.preferred_time_id})"
