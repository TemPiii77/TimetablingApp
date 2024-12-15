class Teacher:
    def __init__(self, id: str, user: 'User', job_title: str):
        self.id = id
        self.user = user
        self.job_title = job_title

    def __str__(self):
        return f"Teacher(id={self.id}, user={self.user}, job_title={self.job_title})"
