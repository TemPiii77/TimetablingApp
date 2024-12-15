class Classroom:
    def __init__(self, id: int, name: str, type: str, double_size: bool = None):
        self.id = id
        self.name = name
        self.type = type
        self.double_size = double_size

    def __str__(self):
        return f"Classroom(id={self.id}, name={self.name}, type={self.type}, double_size={self.double_size})"
