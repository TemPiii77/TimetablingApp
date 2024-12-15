class ClassSubject:
    def __init__(self, id: 'ClassSubjectId', classField: 'Class', subject: 'Subject'):
        self.id = id
        self.classField = classField
        self.subject = subject

    def __str__(self):
        return f"ClassSubject(id={self.id}, classField={self.classField}, subject={self.subject})"
