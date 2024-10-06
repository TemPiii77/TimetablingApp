package org.example.backend.service;

import org.example.backend.domain.Delay;
import org.example.backend.domain.Grade;
import org.example.backend.dto.DelayDto;
import org.example.backend.dto.GradeDto;
import org.example.backend.repository.DelayRepository;
import org.example.backend.repository.GradeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DelayService {

    private DelayRepository delayRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setDelayRepository(DelayRepository delayRepository) {
        this.delayRepository = delayRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<DelayDto> getDelays() {
        return delayRepository.findAll().stream().map((e) -> modelMapper.map(e, DelayDto.class)).toList();
    }

    public DelayDto getDelay(Integer id) {
        return delayRepository.findById(id).map((e) -> modelMapper.map(e, DelayDto.class)).orElse(null);
    }

    public void saveDelay(DelayDto delayDto) {
        Delay delay = modelMapper.map(delayDto, Delay.class);
        delayRepository.save(delay);
    }

    public void updateDelay(DelayDto delayDto) {
        Delay delay = modelMapper.map(delayDto, Delay.class);
        delayRepository.save(delay);
    }

    public void deleteDelay(Integer id) {
        delayRepository.deleteById(id);
    }
}
