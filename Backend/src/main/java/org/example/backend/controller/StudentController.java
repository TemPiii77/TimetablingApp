package org.example.backend.controller;

import org.example.backend.dto.*;
import org.example.backend.service.AbsenceService;
import org.example.backend.service.ClassService;
import org.example.backend.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private ClassService classService;
    private AbsenceService absenceService;

    @Autowired
    public void setClassService(ClassService classService) {
        this.classService = classService;
    }

    @Autowired
    public void setAbsenceService(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @PostMapping("/studentsClasses")
    public List<ClassDto> getStudentsClasses(@RequestBody UserDto userDto) {
        return classService.getStudentsClasses(userDto);
    }

    @PostMapping("/studentsAbsences/{year}")
    public List<AbsenceDto> getScene(@PathVariable Integer year, @RequestBody UserDto userDto) {
        return absenceService.getStudentsAbsences(userDto, year);
    }



}
