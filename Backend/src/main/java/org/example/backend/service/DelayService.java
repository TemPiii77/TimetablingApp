package org.example.backend.service;

import org.example.backend.domain.Delay;
import org.example.backend.domain.Grade;
import org.example.backend.dto.AbsenceDto;
import org.example.backend.dto.DelayDto;
import org.example.backend.dto.GradeDto;
import org.example.backend.dto.UserDto;
import org.example.backend.repository.DelayRepository;
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

    public List<DelayDto> getStudentsDelays(UserDto userDto, Integer year) {

        String minimumYear = year + "-09-01";
        String maximumYear = (year+1) + "-07-01";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate minLocalDate = LocalDate.parse(minimumYear, formatter);
        LocalDate maxLocalDate = LocalDate.parse(maximumYear, formatter);

        Instant minYear = minLocalDate.atStartOfDay(ZoneId.of("UTC")).toInstant();
        Instant maxYear = maxLocalDate.atStartOfDay(ZoneId.of("UTC")).toInstant();

        return delayRepository.findDelaysByYear(userDto.getId(), minYear, maxYear).stream().map((e) -> modelMapper.map(e, DelayDto.class)).toList();
    }
}
