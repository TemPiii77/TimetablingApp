class Class:
    def __init__(self, id: int, year: int, grade: int, group: str, field: str):
        self.id = id
        self.year = year
        self.grade = grade
        self.group = group
        self.field = field

    def __str__(self):
        return f"Class(id={self.id}, year={self.year}, grade={self.grade}, group={self.group}, field={self.field})"