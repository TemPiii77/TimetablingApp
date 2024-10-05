package org.example.backend.controller;

import org.apache.tomcat.util.json.JSONParser;
import org.example.backend.domain.SubjectSubjectRequirementId;
import org.example.backend.domain.TeacherSubjectId;
import org.example.backend.domain.User;
import org.example.backend.dto.*;
import org.example.backend.repository.UserChatRepository;
import org.example.backend.repository.UserRepository;
import org.example.backend.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private ClassroomService classroomService;
    private SubjectService subjectService;
    private ClassService classService;
    private SubjectRequirementService subjectRequirementService;
    private PreferredTimeService preferredTimeService;
    private SubjectSubjectRequirementService subjectSubjectRequirementService;
    private ChatService chatService;
    private StudentClassService studentClassService;
    private TeacherSubjectService teacherSubjectService;
    private ClassSubjectService classSubjectService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setClassroomService(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @Autowired
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Autowired
    public void setClassService(ClassService classService) {
        this.classService = classService;
    }

    @Autowired
    public void setSubjectRequirementService(SubjectRequirementService subjectRequirementService) {
        this.subjectRequirementService = subjectRequirementService;
    }

    @Autowired
    public void setPreferredTimeService(PreferredTimeService preferredTimeService) {
        this.preferredTimeService = preferredTimeService;
    }

    @Autowired
    public void setSubjectSubjectRequirementService(SubjectSubjectRequirementService subjectSubjectRequirementService) {
        this.subjectSubjectRequirementService = subjectSubjectRequirementService;
    }

    @Autowired
    public void setChatService(ChatService chatService) {
        this.chatService = chatService;
    }

    @Autowired
    public void setStudentClassService(StudentClassService studentClassService) {
        this.studentClassService = studentClassService;
    }

    @Autowired
    public void setTeacherSubjectService(TeacherSubjectService teacherSubjectService) {
        this.teacherSubjectService = teacherSubjectService;
    }

    @Autowired
    public void setClassSubjectService(ClassSubjectService classSubjectService) {
        this.classSubjectService = classSubjectService;
    }







    @GetMapping("/user")
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public UserDto getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @PostMapping("/register")
    public void saveUser(@RequestBody UserDto userDto, @RequestParam("name") String roleBasedInformation) {

        userService.saveUser(userDto, roleBasedInformation);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserDto userDto, @RequestParam("name") String roleBasedInformation) {
        userService.updateUser(userDto, roleBasedInformation);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }


    @GetMapping("/classroom")
    public List<ClassroomDto> getClassrooms() {
        return classroomService.getClassrooms();
    }

    @GetMapping("/classroom/{id}")
    public ClassroomDto getClassroom(@PathVariable Integer id) {
        return classroomService.getClassroom(id);
    }

    @PostMapping("/classroom")
    public void saveClassroom(@RequestBody ClassroomDto classroomDto) {
        classroomService.saveClassroom(classroomDto);
    }

    @PutMapping("/classroom")
    public void updateClassroom(@RequestBody ClassroomDto classroomDto) {
        classroomService.updateClassroom(classroomDto);
    }

    @DeleteMapping("/classroom/{id}")
    public void deleteClassroom(@PathVariable Integer id) {
        classroomService.deleteClassroom(id);
    }




    @GetMapping("/subject")
    public List<SubjectDto> getSubjects() {
        return subjectService.getSubjects();
    }

    @GetMapping("/subject/{id}")
    public SubjectDto getSubject(@PathVariable Integer id) {
        return subjectService.getSubject(id);
    }

    @PostMapping("/subject")
    public void saveSubject(@RequestBody SubjectDto subjectDto) {
        subjectService.saveSubject(subjectDto);
    }

    @PutMapping("/subject")
    public void updateSubject(@RequestBody SubjectDto subjectDto) {
        subjectService.updateSubject(subjectDto);
    }

    @DeleteMapping("/subject/{id}")
    public void deleteSubject(@PathVariable Integer id) {
        subjectService.deleteSubject(id);
    }



    @GetMapping("/class")
    public List<ClassDto> getClasses() {
        return classService.getClasses();
    }

    @GetMapping("/class/{id}")
    public ClassDto getClass(@PathVariable Integer id) {
        return classService.getClass(id);
    }

    @PostMapping("/class")
    public void saveClass(@RequestBody ClassDto classDto) {
        classService.saveClass(classDto);
    }

    @PutMapping("/class")
    public void updateClass(@RequestBody ClassDto classDto) {
        classService.updateClass(classDto);
    }

    @DeleteMapping("/class/{id}")
    public void deleteClass(@PathVariable Integer id) {
        classService.deleteClass(id);
    }


    @GetMapping("/subjectRequirement")
    public List<SubjectRequirementDto> getSubjectRequirements() {
        return subjectRequirementService.getSubjectRequirements();
    }

    @GetMapping("/subjectRequirement/{id}")
    public SubjectRequirementDto getSubjectRequirement(@PathVariable Integer id) {
        return subjectRequirementService.getSubjectRequirement(id);
    }

    @PostMapping("/subjectRequirement")
    public void saveSubjectRequirement(@RequestBody SubjectRequirementDto subjectRequirementDto) {
        subjectRequirementService.saveSubjectRequirement(subjectRequirementDto);
    }

    @PutMapping("/subjectRequirement")
    public void updateSubjectRequirement(@RequestBody SubjectRequirementDto subjectRequirementDto) {
        subjectRequirementService.updateSubjectRequirement(subjectRequirementDto);
    }

    @DeleteMapping("/subjectRequirement/{id}")
    public void deleteSubjectRequirement(@PathVariable Integer id) {
        subjectRequirementService.deleteSubjectRequirement(id);
    }




    @GetMapping("/preferredTime")
    public List<PreferredTimeDto> getPreferredTimes() {
        return preferredTimeService.getPreferredTimes();
    }

    @GetMapping("/preferredTime/{id}")
    public PreferredTimeDto getPreferredTime(@PathVariable Integer id) {
        return preferredTimeService.getPreferredTime(id);
    }

    @PostMapping("/preferredTime")
    public void savePreferredTime(@RequestBody PreferredTimeDto preferredTimeDto) {
        preferredTimeService.savePreferredTime(preferredTimeDto);
    }

    @PutMapping("/preferredTime")
    public void updatePreferredTime(@RequestBody PreferredTimeDto preferredTimeDto) {
        preferredTimeService.updatePreferredTime(preferredTimeDto);
    }

    @DeleteMapping("/preferredTime/{id}")
    public void deletePreferredTime(@PathVariable Integer id) {
        preferredTimeService.deletePreferredTime(id);
    }




    @GetMapping("/chat")
    public List<ChatDto> getChats() {
        return chatService.getChats();
    }

    @GetMapping("/chat/{id}")
    public ChatDto getChat(@PathVariable Integer id) {
        return chatService.getChat(id);
    }

    @PostMapping("/chat")
    public void saveChat(@RequestBody ChatDto chatDto) {
        chatService.saveChat(chatDto);
    }

    @PutMapping("/chat")
    public void updateChat(@RequestBody ChatDto chatDto) {
        chatService.updateChat(chatDto);
    }

    @DeleteMapping("/chat/{id}")
    public void deleteChat(@PathVariable Integer id) {
        chatService.deleteChat(id);
    }














    @GetMapping("/subjectSubjectRequirement")
    public List<SubjectSubjectRequirementDto> getSubjectSubjectRequirements() {
        return subjectSubjectRequirementService.getSubjectSubjectRequirements();
    }

    @GetMapping("/subjectSubjectRequirement/{subjectId}_{subjectRequirementId}")
    public SubjectSubjectRequirementDto getSubjectSubjectRequirement(@PathVariable Integer subjectId, @PathVariable Integer subjectRequirementId) {
        return subjectSubjectRequirementService.getSubjectSubjectRequirement(subjectId, subjectRequirementId);
    }

    @PostMapping("/subjectSubjectRequirement")
    public void saveSubjectSubjectRequirement(@RequestBody SubjectSubjectRequirementIdDto subjectSubjectRequirementIdDto) {
        subjectSubjectRequirementService.saveSubjectSubjectRequirement(subjectSubjectRequirementIdDto);
    }

    @PutMapping("/subjectSubjectRequirement")
    public void updateSubjectSubjectRequirement(@RequestBody SubjectSubjectRequirementIdDto subjectSubjectRequirementIdDto) {
        subjectSubjectRequirementService.updateSubjectSubjectRequirement(subjectSubjectRequirementIdDto);
    }

    @DeleteMapping("/subjectSubjectRequirement/{subjectId}_{subjectRequirementId}")
    public void deleteSubjectSubjectRequirement(@PathVariable Integer subjectId, @PathVariable Integer subjectRequirementId) {
        subjectSubjectRequirementService.deleteSubjectSubjectRequirement(subjectId, subjectRequirementId);
    }



    @GetMapping("/studentClass")
    public List<StudentClassDto> getStudentClasses() {
        return studentClassService.getStudentClasses();
    }

    @GetMapping("/studentClass/{studentId}_{classId}")
    public StudentClassDto getStudentClass(@PathVariable String studentId, @PathVariable Integer classId) {
        return studentClassService.getStudentClass(studentId, classId);
    }

    @PostMapping("/studentClass")
    public void saveStudentClass(@RequestBody StudentClassIdDto studentClassIdDto) {
        studentClassService.saveStudentClass(studentClassIdDto);
    }

    @PutMapping("/studentClass")
    public void updateStudentClass(@RequestBody StudentClassIdDto studentClassIdDto) {
        studentClassService.updateStudentClass(studentClassIdDto);
    }

    @DeleteMapping("/studentClass/{studentId}_{classId}")
    public void deleteStudentClass(@PathVariable String studentId, @PathVariable Integer classId) {
        studentClassService.deleteStudentClass(studentId, classId);
    }


    @GetMapping("/teacherSubject")
    public List<TeacherSubjectDto> getTeacherSubjects() {
        return teacherSubjectService.getTeacherSubjects();
    }

    @GetMapping("/teacherSubject/{teacherId}_{subjectId}")
    public TeacherSubjectDto getTeacherSubject(@PathVariable String teacherId, @PathVariable Integer subjectId) {
        return teacherSubjectService.getTeacherSubject(teacherId, subjectId);
    }

    @PostMapping("/teacherSubject")
    public void saveTeacherSubject(@RequestBody TeacherSubjectIdDto teacherSubjectIdDto) {
        teacherSubjectService.saveTeacherSubject(teacherSubjectIdDto);
    }

    @PutMapping("/teacherSubject")
    public void updateTeacherSubject(@RequestBody TeacherSubjectIdDto teacherSubjectIdDto) {
        teacherSubjectService.updateTeacherSubject(teacherSubjectIdDto);
    }

    @DeleteMapping("/teacherSubject/{teacherId}_{subjectId}")
    public void deleteTeacherSubject(@PathVariable String teacherId, @PathVariable Integer subjectId) {
        teacherSubjectService.deleteTeacherSubject(teacherId, subjectId);
    }




    @GetMapping("/classSubject")
    public List<ClassSubjectDto> getClassSubjects() {
        return classSubjectService.getClassSubjects();
    }

    @GetMapping("/classSubject/{classId}_{subjectId}")
    public ClassSubjectDto getClassSubject(@PathVariable Integer classId, @PathVariable Integer subjectId) {
        return classSubjectService.getClassSubject(classId, subjectId);
    }

    @PostMapping("/classSubject")
    public void saveClassSubject(@RequestBody ClassSubjectIdDto classSubjectIdDto) {
        classSubjectService.saveClassSubject(classSubjectIdDto);
    }

    @PutMapping("/classSubject")
    public void updateClassSubject(@RequestBody ClassSubjectIdDto classSubjectIdDto) {
        classSubjectService.updateClassSubject(classSubjectIdDto);
    }

    @DeleteMapping("/classSubject/{classId}_{subjectId}")
    public void deleteClassSubject(@PathVariable Integer classId, @PathVariable Integer subjectId) {
        classSubjectService.deleteClassSubject(classId, subjectId);
    }












}
