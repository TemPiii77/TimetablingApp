package org.example.backend.service;

import org.example.backend.domain.Classroom;
import org.example.backend.domain.Timeslot;
import org.example.backend.dto.ClassroomDto;
import org.example.backend.dto.TimeslotDto;
import org.example.backend.repository.ClassroomRepository;
import org.example.backend.repository.TimeslotRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeslotService {

    private TimeslotRepository timeslotRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setTimeslotRepository(TimeslotRepository timeslotRepository) {
        this.timeslotRepository = timeslotRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<TimeslotDto> getTimeslots() {
        return timeslotRepository.findAll().stream().map((e) -> modelMapper.map(e, TimeslotDto.class)).toList();
    }

    public TimeslotDto getTimeslot(Integer id) {
        return timeslotRepository.findById(id).map((e) -> modelMapper.map(e, TimeslotDto.class)).orElse(null);
    }

    public void saveTimeslot(TimeslotDto timeslotDto) {
        Timeslot timeslot = modelMapper.map(timeslotDto, Timeslot.class);
        timeslotRepository.save(timeslot);
    }

    public void updateTimeslot(TimeslotDto timeslotDto) {
        Timeslot timeslot = modelMapper.map(timeslotDto, Timeslot.class);
        timeslotRepository.save(timeslot);
    }

    public void deleteTimeslot(Integer id) {
        timeslotRepository.deleteById(id);
    }
}
