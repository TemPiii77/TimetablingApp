package org.example.backend.service;

import org.example.backend.domain.Absence;
import org.example.backend.domain.Grade;
import org.example.backend.dto.AbsenceDto;
import org.example.backend.dto.GradeDto;
import org.example.backend.dto.UserDto;
import org.example.backend.repository.AbsenceRepository;
import org.example.backend.repository.GradeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AbsenceService {

    private AbsenceRepository absenceRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setAbsenceRepository(AbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<AbsenceDto> getAbsences() {
        return absenceRepository.findAll().stream().map((e) -> modelMapper.map(e, AbsenceDto.class)).toList();
    }

    public AbsenceDto getAbsence(Integer id) {
        return absenceRepository.findById(id).map((e) -> modelMapper.map(e, AbsenceDto.class)).orElse(null);
    }

    public void saveAbsence(AbsenceDto absenceDto) {
        Absence absence = modelMapper.map(absenceDto, Absence.class);
        absenceRepository.save(absence);
    }

    public void updateAbsence(AbsenceDto absenceDto) {
        Absence absence = modelMapper.map(absenceDto, Absence.class);
        absenceRepository.save(absence);
    }

    public void deleteAbsence(Integer id) {
        absenceRepository.deleteById(id);
    }

    public List<AbsenceDto> getStudentsAbsences(UserDto userDto, Integer year) {

        String minimumYear = year + "-09-01";
        String maximumYear = (year+1) + "-07-01";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate minLocalDate = LocalDate.parse(minimumYear, formatter);
        LocalDate maxLocalDate = LocalDate.parse(maximumYear, formatter);

        Instant minYear = minLocalDate.atStartOfDay(ZoneId.of("UTC")).toInstant();
        Instant maxYear = maxLocalDate.atStartOfDay(ZoneId.of("UTC")).toInstant();

        return absenceRepository.findAbsencesByYear(userDto.getId(), minYear, maxYear).stream().map((e) -> modelMapper.map(e, AbsenceDto.class)).toList();
    }
}
