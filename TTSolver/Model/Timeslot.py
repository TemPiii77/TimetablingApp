class Timeslot:
    def __init__(self, id: int, year: int, day: str, hour: int, class_field: 'Class', teacher: 'Teacher', subject: 'Subject', classroom: 'Classroom'):
        self.id = id
        self.year = year
        self.day = day
        self.hour = hour
        self.class_field = class_field
        self.teacher = teacher
        self.subject = subject
        self.classroom = classroom

    def __str__(self):
        return f"Timeslot(id={self.id}, year={self.year}, day={self.day}, hour={self.hour}, class_field={self.class_field}, teacher={self.teacher}, subject={self.subject}, classroom={self.classroom})"
