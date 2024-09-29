package org.example.backend.controller;

import org.example.backend.domain.SubjectSubjectRequirementId;
import org.example.backend.domain.User;
import org.example.backend.dto.*;
import org.example.backend.repository.UserChatRepository;
import org.example.backend.repository.UserRepository;
import org.example.backend.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private ClassroomService classroomService;
    private SubjectService subjectService;
    private ClassService classService;
    private SubjectRequirementService subjectRequirementService;
    private PreferredTimeService preferredTimeService;
    private SubjectSubjectRequirementService subjectSubjectRequirementService;


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
}
