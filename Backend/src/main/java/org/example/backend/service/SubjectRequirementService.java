package org.example.backend.service;

import org.example.backend.domain.Classroom;
import org.example.backend.domain.SubjectRequirement;
import org.example.backend.dto.ClassroomDto;
import org.example.backend.dto.SubjectRequirementDto;
import org.example.backend.repository.ClassroomRepository;
import org.example.backend.repository.SubjectRequirementRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectRequirementService {

    private SubjectRequirementRepository subjectRequirementRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setSubjectRequirementRepository(SubjectRequirementRepository subjectRequirementRepository) {
        this.subjectRequirementRepository = subjectRequirementRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<SubjectRequirementDto> getSubjectRequirements() {
        return subjectRequirementRepository.findAll().stream().map((e) -> modelMapper.map(e, SubjectRequirementDto.class)).toList();
    }

    public SubjectRequirementDto getSubjectRequirement(Integer id) {
        return subjectRequirementRepository.findById(id).map((e) -> modelMapper.map(e, SubjectRequirementDto.class)).orElse(null);
    }

    public void saveSubjectRequirement(SubjectRequirementDto subjectRequirementDto) {
        SubjectRequirement subjectRequirement = modelMapper.map(subjectRequirementDto, SubjectRequirement.class);
        subjectRequirementRepository.save(subjectRequirement);
    }

    public void updateSubjectRequirement(SubjectRequirementDto subjectRequirementDto) {
        SubjectRequirement subjectRequirement = modelMapper.map(subjectRequirementDto, SubjectRequirement.class);
        subjectRequirementRepository.save(subjectRequirement);
    }

    public void deleteSubjectRequirement(Integer id) {
        subjectRequirementRepository.deleteById(id);
    }
}
