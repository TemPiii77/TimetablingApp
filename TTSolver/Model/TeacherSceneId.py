class TeacherSceneId:
    def __init__(self, teacher_id: str, scene_id: int):
        self.teacher_id = teacher_id
        self.scene_id = scene_id

    def __str__(self):
        return f"TeacherSceneId(teacher_id={self.teacher_id}, scene_id={self.scene_id})"
