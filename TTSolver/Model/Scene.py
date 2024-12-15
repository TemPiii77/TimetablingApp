class Scene:
    def __init__(self, id: int, name: str, subject: 'Subject'):
        self.id = id
        self.name = name
        self.subject = subject

    def __str__(self):
        return f"Scene(id={self.id}, name={self.name}, subject={self.subject})"
