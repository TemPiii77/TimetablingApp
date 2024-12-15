class ClassSceneId:
    def __init__(self, class_id: int, scene_id: int):
        self.class_id = class_id
        self.scene_id = scene_id

    def __str__(self):
        return f"ClassSceneId(class_id={self.class_id}, scene_id={self.scene_id})"
