class PreferredTime:
    def __init__(self, id: int, day: str, hour: int):
        self.id = id
        self.day = day
        self.hour = hour

    def __str__(self):
        return f"PreferredTime(id={self.id}, day={self.day}, hour={self.hour})"
