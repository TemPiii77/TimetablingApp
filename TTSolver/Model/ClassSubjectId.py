class ClassSubjectId:
    def __init__(self, class_id: int, subject_id: int):
        self.class_id = class_id
        self.subject_id = subject_id

    def __str__(self):
        return f"ClassSubjectId(class_id={self.class_id}, subject_id={self.subject_id})"
