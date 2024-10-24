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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private StudentService studentService;
    private AdminService adminService;
    private TeacherService teacherService;
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
    private TeacherPreferredTimeService teacherPreferredTimeService;
    private TimeslotService timeslotService;
    private GradeService gradeService;
    private AbsenceService absenceService;
    private DelayService delayService;
    private ProblemService problemService;
    private SceneService sceneService;
    private ScenePartService scenePartService;
    private SceneCommentService sceneCommentService;
    private ChatCommentService chatCommentService;
    private TeacherSceneService teacherSceneService;
    private ClassSceneService classSceneService;
    private UserChatService userChatService;



    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
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

    @Autowired
    public void setTeacherPreferredTimeService(TeacherPreferredTimeService teacherPreferredTimeService) {
        this.teacherPreferredTimeService = teacherPreferredTimeService;
    }

    @Autowired
    public void setTimeslotService(TimeslotService timeslotService) {
        this.timeslotService = timeslotService;
    }

    @Autowired
    public void setGradeService(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @Autowired
    public void setAbsenceService(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @Autowired
    public void setDelayService(DelayService delayService) {
        this.delayService = delayService;
    }

    @Autowired
    public void setProblemService(ProblemService problemService) {
        this.problemService = problemService;
    }

    @Autowired
    public void setSceneService(SceneService sceneService) {
        this.sceneService = sceneService;
    }

    @Autowired
    public void setScenePartService(ScenePartService scenePartService) {
        this.scenePartService = scenePartService;
    }

    @Autowired
    public void setSceneCommentService(SceneCommentService sceneCommentService) {
        this.sceneCommentService = sceneCommentService;
    }

    @Autowired
    public void setChatCommentService(ChatCommentService chatCommentService) {
        this.chatCommentService = chatCommentService;
    }

    @Autowired
    public void setTeacherSceneService(TeacherSceneService teacherSceneService) {
        this.teacherSceneService = teacherSceneService;
    }

    @Autowired
    public void setClassSceneService(ClassSceneService classSceneService) {
        this.classSceneService = classSceneService;
    }

    @Autowired
    public void setUserChatService(UserChatService userChatService) {
        this.userChatService = userChatService;
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


    @GetMapping("/student")
    public List<StudentDto> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/admin")
    public List<AdminDto> getAdmins() {
        return adminService.getAdmins();
    }

    @GetMapping("/teacher")
    public List<TeacherDto> getTeachers() {
        return teacherService.getTeachers();
    }

    @PutMapping("/teacher")
    public void updateTeacher(@RequestBody TeacherDto teacherDto) {
        teacherService.updateTeacher(teacherDto);
    }


    @GetMapping("/classroom")
    public List<ClassroomDto> getClassrooms() {
        return classroomService.getClassrooms();
    }

    @GetMapping("/classroom/{id}")
    public ClassroomDto getClassroom(@PathVariable Integer id) {
        return classroomService.getClassroom(id);
    }

//    @PostMapping("/classroom")
//    public void saveClassroom(@RequestBody ClassroomDto classroomDto) {
//        classroomService.saveClassroom(classroomDto);
//    }

    @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
    @PostMapping("/classroom")
    public ResponseEntity<Void> saveClassroom(@RequestBody ClassroomDto classroomDto) {
        classroomService.saveClassroom(classroomDto);
        return ResponseEntity.ok().build();
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



    @GetMapping("/teacherPreferredTime")
    public List<TeacherPreferredTimeDto> getTeacherPreferredTimes() {
        return teacherPreferredTimeService.getTeacherPreferredTimes();
    }

    @GetMapping("/teacherPreferredTime/{teacherId}_{preferredTimeId}")
    public TeacherPreferredTimeDto getTeacherPreferredTime(@PathVariable String teacherId, @PathVariable Integer preferredTimeId) {
        return teacherPreferredTimeService.getTeacherPreferredTime(teacherId, preferredTimeId);
    }

    @PostMapping("/teacherPreferredTime")
    public void saveTeacherPreferredTime(@RequestBody TeacherPreferredTimeIdDto teacherPreferredTimeIdDto) {
        teacherPreferredTimeService.saveTeacherPreferredTime(teacherPreferredTimeIdDto);
    }

    @PutMapping("/teacherPreferredTime")
    public void updateTeacherPreferredTime(@RequestBody TeacherPreferredTimeIdDto teacherPreferredTimeIdDto) {
        teacherPreferredTimeService.updateTeacherPreferredTime(teacherPreferredTimeIdDto);
    }

    @DeleteMapping("/teacherPreferredTime/{teacherId}_{preferredTimeId}")
    public void deleteTeacherPreferredTime(@PathVariable String teacherId, @PathVariable Integer preferredTimeId) {
        teacherPreferredTimeService.deleteTeacherPreferredTime(teacherId, preferredTimeId);
    }


    @GetMapping("/timeslot")
    public List<TimeslotDto> getTimeslots() {
        return timeslotService.getTimeslots();
    }

    @GetMapping("/timeslot/{id}")
    public TimeslotDto getTimeslot(@PathVariable Integer id) {
        return timeslotService.getTimeslot(id);
    }

    @PostMapping("/timeslot")
    public void saveTimeslot(@RequestBody TimeslotDto timeslotDto) {
        timeslotService.saveTimeslot(timeslotDto);
    }

    @PutMapping("/timeslot")
    public void updateTimeslot(@RequestBody TimeslotDto timeslotDto) {
        timeslotService.updateTimeslot(timeslotDto);
    }

    @DeleteMapping("/timeslot/{id}")
    public void deleteTimeslot(@PathVariable Integer id) {
        timeslotService.deleteTimeslot(id);
    }

    @GetMapping("/grade")
    public List<GradeDto> getGrades() {
        return gradeService.getGrades();
    }

    @GetMapping("/grade/{id}")
    public GradeDto getGrade(@PathVariable Integer id) {
        return gradeService.getGrade(id);
    }

    @PostMapping("/grade")
    public void saveGrade(@RequestBody GradeDto gradeDto) {
        gradeService.saveGrade(gradeDto);
    }

    @PutMapping("/grade")
    public void updateGrade(@RequestBody GradeDto gradeDto) {
        gradeService.updateGrade(gradeDto);
    }

    @DeleteMapping("/grade/{id}")
    public void deleteGrade(@PathVariable Integer id) {
        gradeService.deleteGrade(id);
    }

    @GetMapping("/absence")
    public List<AbsenceDto> getAbsences() {
        return absenceService.getAbsences();
    }

    @GetMapping("/absence/{id}")
    public AbsenceDto getAbsence(@PathVariable Integer id) {
        return absenceService.getAbsence(id);
    }

    @PostMapping("/absence")
    public void saveAbsence(@RequestBody AbsenceDto absenceDto) {
        absenceService.saveAbsence(absenceDto);
    }

    @PutMapping("/absence")
    public void updateAbsence(@RequestBody AbsenceDto absenceDto) {
        absenceService.updateAbsence(absenceDto);
    }

    @DeleteMapping("/absence/{id}")
    public void deleteAbsence(@PathVariable Integer id) {
        absenceService.deleteAbsence(id);
    }


    @GetMapping("/delay")
    public List<DelayDto> getDelays() {
        return delayService.getDelays();
    }

    @GetMapping("/delay/{id}")
    public DelayDto getDelay(@PathVariable Integer id) {
        return delayService.getDelay(id);
    }

    @PostMapping("/delay")
    public void saveDelay(@RequestBody DelayDto delayDto) {
        delayService.saveDelay(delayDto);
    }

    @PutMapping("/delay")
    public void updateDelay(@RequestBody DelayDto delayDto) {
        delayService.updateDelay(delayDto);
    }

    @DeleteMapping("/delay/{id}")
    public void deleteDelay(@PathVariable Integer id) {
        delayService.deleteDelay(id);
    }

    @GetMapping("/problem")
    public List<ProblemDto> getProblems() {
        return problemService.getProblems();
    }

    @GetMapping("/problem/{id}")
    public ProblemDto getProblem(@PathVariable Integer id) {
        return problemService.getProblem(id);
    }

    @PostMapping("/problem")
    public void saveProblem(@RequestBody ProblemDto problemDto) {
        problemService.saveProblem(problemDto);
    }

    @PutMapping("/problem")
    public void updateProblem(@RequestBody ProblemDto problemDto) {
        problemService.updateProblem(problemDto);
    }

    @DeleteMapping("/problem/{id}")
    public void deleteProblem(@PathVariable Integer id) {
        problemService.deleteProblem(id);
    }

    @GetMapping("/scene")
    public List<SceneDto> getScenes() {
        return sceneService.getScenes();
    }

    @GetMapping("/scene/{id}")
    public SceneDto getScene(@PathVariable Integer id) {
        return sceneService.getScene(id);
    }

    @PostMapping("/scene")
    public void saveScene(@RequestBody SceneDto sceneDto) {
        sceneService.saveScene(sceneDto);
    }

    @PutMapping("/scene")
    public void updateScene(@RequestBody SceneDto sceneDto) {
        sceneService.updateScene(sceneDto);
    }

    @DeleteMapping("/scene/{id}")
    public void deleteScene(@PathVariable Integer id) {
        sceneService.deleteScene(id);
    }


    @GetMapping("/scenePart")
    public List<ScenePartDto> getSceneParts() {
        return scenePartService.getSceneParts();
    }

    @GetMapping("/scenePart/{id}")
    public ScenePartDto getScenePart(@PathVariable Integer id) {
        return scenePartService.getScenePart(id);
    }

    @PostMapping("/scenePart")
    public void saveScenePart(@RequestBody ScenePartDto scenePartDto) {
        scenePartService.saveScenePart(scenePartDto);
    }

    @PutMapping("/scenePart")
    public void updateScenePart(@RequestBody ScenePartDto scenePartDto) {
        scenePartService.updateScenePart(scenePartDto);
    }

    @DeleteMapping("/scenePart/{id}")
    public void deleteScenePart(@PathVariable Integer id) {
        scenePartService.deleteScenePart(id);
    }



    @GetMapping("/sceneComment")
    public List<SceneCommentDto> getSceneComments() {
        return sceneCommentService.getSceneComments();
    }

    @GetMapping("/sceneComment/{id}")
    public SceneCommentDto getSceneComment(@PathVariable Integer id) {
        return sceneCommentService.getSceneComment(id);
    }

    @PostMapping("/sceneComment")
    public void saveSceneComment(@RequestBody SceneCommentDto sceneCommentDto) {
        sceneCommentService.saveSceneComment(sceneCommentDto);
    }

    @PutMapping("/sceneComment")
    public void updateSceneComment(@RequestBody SceneCommentDto sceneCommentDto) {
        sceneCommentService.updateSceneComment(sceneCommentDto);
    }

    @DeleteMapping("/sceneComment/{id}")
    public void deleteSceneComment(@PathVariable Integer id) {
        sceneCommentService.deleteSceneComment(id);
    }


    @GetMapping("/chatComment")
    public List<ChatCommentDto> getChatComments() {
        return chatCommentService.getChatComments();
    }

    @GetMapping("/chatComment/{id}")
    public ChatCommentDto getChatComment(@PathVariable Integer id) {
        return chatCommentService.getChatComment(id);
    }

    @PostMapping("/chatComment")
    public void saveChatComment(@RequestBody ChatCommentDto chatCommentDto) {
        chatCommentService.saveChatComment(chatCommentDto);
    }

    @PutMapping("/chatComment")
    public void updateChatComment(@RequestBody ChatCommentDto chatCommentDto) {
        chatCommentService.updateChatComment(chatCommentDto);
    }

    @DeleteMapping("/chatComment/{id}")
    public void deleteChatComment(@PathVariable Integer id) {
        chatCommentService.deleteChatComment(id);
    }


    @GetMapping("/teacherScene")
    public List<TeacherSceneDto> getTeacherScenes() {
        return teacherSceneService.getTeacherScenes();
    }

    @GetMapping("/teacherScene/{teacherId}_{sceneId}")
    public TeacherSceneDto getTeacherScene(@PathVariable String teacherId, @PathVariable Integer sceneId) {
        return teacherSceneService.getTeacherScene(teacherId, sceneId);
    }

    @PostMapping("/teacherScene")
    public void saveTeacherScene(@RequestBody TeacherSceneIdDto teacherSceneIdDto) {
        teacherSceneService.saveTeacherScene(teacherSceneIdDto);
    }

    @PutMapping("/teacherScene")
    public void updateTeacherScene(@RequestBody TeacherSceneIdDto teacherSceneIdDto) {
        teacherSceneService.updateTeacherScene(teacherSceneIdDto);
    }

    @DeleteMapping("/teacherScene/{teacherId}_{sceneId}")
    public void deleteTeacherScene(@PathVariable String teacherId, @PathVariable Integer sceneId) {
        teacherSceneService.deleteTeacherScene(teacherId, sceneId);
    }


    @GetMapping("/classScene")
    public List<ClassSceneDto> getClassScenes() {
        return classSceneService.getClassScenes();
    }

    @GetMapping("/classScene/{classId}_{sceneId}")
    public ClassSceneDto getClassScene(@PathVariable Integer classId, @PathVariable Integer sceneId) {
        return classSceneService.getClassScene(classId, sceneId);
    }

    @PostMapping("/classScene")
    public void saveClassScene(@RequestBody ClassSceneIdDto classSceneIdDto) {
        classSceneService.saveClassScene(classSceneIdDto);
    }

    @PutMapping("/classScene")
    public void updateClassScene(@RequestBody ClassSceneIdDto classSceneIdDto) {
        classSceneService.updateClassScene(classSceneIdDto);
    }

    @DeleteMapping("/classScene/{classId}_{sceneId}")
    public void deleteClassScene(@PathVariable Integer classId, @PathVariable Integer sceneId) {
        classSceneService.deleteClassScene(classId, sceneId);
    }




    @GetMapping("/userChat")
    public List<UserChatDto> getUserChats() {
        return userChatService.getUserChats();
    }

    @GetMapping("/userChat/{userId}_{chatId}")
    public UserChatDto getUserChat(@PathVariable String userId, @PathVariable Integer chatId) {
        return userChatService.getUserChat(userId, chatId);
    }

    @PostMapping("/userChat")
    public void saveUserChat(@RequestBody UserChatIdDto userChatIdDto) {
        userChatService.saveUserChat(userChatIdDto);
    }

    @PutMapping("/userChat")
    public void updateUserChat(@RequestBody UserChatIdDto userChatIdDto) {
        userChatService.updateUserChat(userChatIdDto);
    }

    @DeleteMapping("/userChat/{userId}_{chatId}")
    public void deleteUserChat(@PathVariable String userId, @PathVariable Integer chatId) {
        userChatService.deleteUserChat(userId, chatId);
    }



}
