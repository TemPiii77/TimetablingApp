class Subject:
    def __init__(self, id: int, name: str):
        self.id = id
        self.name = name

    def __str__(self):
        return f"Subject(id={self.id}, name={self.name})"
