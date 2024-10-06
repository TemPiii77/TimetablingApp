package org.example.backend.service;

import org.example.backend.domain.Absence;
import org.example.backend.domain.Grade;
import org.example.backend.dto.AbsenceDto;
import org.example.backend.dto.GradeDto;
import org.example.backend.repository.AbsenceRepository;
import org.example.backend.repository.GradeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
