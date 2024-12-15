class User:
    def __init__(self, id: str, email: str, last_name: str, first_name: str, password: str, role: str):
        self.id = id
        self.email = email
        self.last_name = last_name
        self.first_name = first_name
        self.password = password
        self.role = role

    def __str__(self):
        return f"User(id={self.id}, email={self.email}, last_name={self.last_name}, first_name={self.first_name}, role={self.role})"
