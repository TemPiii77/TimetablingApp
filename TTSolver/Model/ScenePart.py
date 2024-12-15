class ScenePart:
    def __init__(self, id: int, name: str, news: bool, scene: 'Scene'):
        self.id = id
        self.name = name
        self.news = news
        self.scene = scene

    def __str__(self):
        return f"ScenePart(id={self.id}, name={self.name}, news={self.news}, scene={self.scene})"
