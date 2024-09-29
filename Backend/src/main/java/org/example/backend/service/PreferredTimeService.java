package org.example.backend.service;

import org.example.backend.domain.Classroom;
import org.example.backend.domain.PreferredTime;
import org.example.backend.dto.ClassroomDto;
import org.example.backend.dto.PreferredTimeDto;
import org.example.backend.repository.ClassroomRepository;
import org.example.backend.repository.PreferredTimeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferredTimeService {

    private PreferredTimeRepository preferredTimeRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setPreferredTimeRepository(PreferredTimeRepository preferredTimeRepository) {
        this.preferredTimeRepository = preferredTimeRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<PreferredTimeDto> getPreferredTimes() {
        return preferredTimeRepository.findAll().stream().map((e) -> modelMapper.map(e, PreferredTimeDto.class)).toList();
    }

    public PreferredTimeDto getPreferredTime(Integer id) {
        return preferredTimeRepository.findById(id).map((e) -> modelMapper.map(e, PreferredTimeDto.class)).orElse(null);
    }

    public void savePreferredTime(PreferredTimeDto preferredTimeDto) {
        PreferredTime preferredTime = modelMapper.map(preferredTimeDto, PreferredTime.class);
        preferredTimeRepository.save(preferredTime);
    }

    public void updatePreferredTime(PreferredTimeDto preferredTimeDto) {
        PreferredTime preferredTime = modelMapper.map(preferredTimeDto, PreferredTime.class);
        preferredTimeRepository.save(preferredTime);
    }

    public void deletePreferredTime(Integer id) {
        preferredTimeRepository.deleteById(id);
    }
}
