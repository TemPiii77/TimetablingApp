package org.example.backend.controller;

import org.example.backend.domain.User;
import org.example.backend.dto.ClassroomDto;
import org.example.backend.dto.SubjectDto;
import org.example.backend.dto.UserDto;
import org.example.backend.repository.UserChatRepository;
import org.example.backend.repository.UserRepository;
import org.example.backend.service.ClassroomService;
import org.example.backend.service.SubjectService;
import org.example.backend.service.TeacherSubjectService;
import org.example.backend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private ClassroomService classroomService;
    private SubjectService subjectService;


    @Autowired
    public void setClassroomService(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @Autowired
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
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



}
