class TeacherPreferredTime:
    def __init__(self, id: 'TeacherPreferredTimeId', teacher: 'Teacher', preferred_time: 'PreferredTime'):
        self.id = id
        self.teacher = teacher
        self.preferred_time = preferred_time

    def __str__(self):
        return f"TeacherPreferredTime(id={self.id}, teacher={self.teacher}, preferred_time={self.preferred_time})"
