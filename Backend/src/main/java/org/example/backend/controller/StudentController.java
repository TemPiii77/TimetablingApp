package org.example.backend.controller;

import org.example.backend.domain.Grade;
import org.example.backend.dto.*;
import org.example.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private ClassService classService;
    private AbsenceService absenceService;
    private DelayService delayService;
    private ProblemService problemService;
    private GradeService gradeService;
    private SubjectService subjectService;
    private TimeslotService timeslotService;


    @Autowired
    public void setClassService(ClassService classService) {
        this.classService = classService;
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
    public void setGradeService(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @Autowired
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Autowired
    public void setTimeslotService(TimeslotService timeslotService) {
        this.timeslotService = timeslotService;
    }


    @PostMapping("/studentsSubjects")
    public List<SubjectDto> getStudentsSubjects(@RequestBody Integer classId) {
        return subjectService.getStudentsSubjects(classId);
    }

    @PostMapping("/studentsAbsences/{year}")
    public List<AbsenceDto> getStudentsAbsences(@PathVariable Integer year, @RequestBody UserDto userDto) {
        return absenceService.getStudentsAbsences(userDto, year);
    }

    @PostMapping("/studentsDelays/{year}")
    public List<DelayDto> getStudentsDelays(@PathVariable Integer year, @RequestBody UserDto userDto) {
        return delayService.getStudentsDelays(userDto, year);
    }

    @PostMapping("/studentsProblems/{year}")
    public List<ProblemDto> getStudentsProblems(@PathVariable Integer year, @RequestBody UserDto userDto) {
        return problemService.getStudentsProblems(userDto, year);
    }

    @PostMapping("/studentsGrades/{classId}/{subjectId}")
    public List<GradeDto> getStudentsGrades(@PathVariable Integer classId, @PathVariable Integer subjectId, @RequestBody UserDto userDto) {
        return gradeService.getStudentsGrades(userDto, classId, subjectId);
    }

    @PostMapping("/studentsTimeslots/{year}")
    public List<TimeslotDto> getStudentsTimeslots(@PathVariable Integer year, @RequestBody UserDto userDto) {
        return timeslotService.getStudentsTimeslots(userDto, year);
    }



}
