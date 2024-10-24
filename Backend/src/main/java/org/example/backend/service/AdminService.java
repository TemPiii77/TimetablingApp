package org.example.backend.service;

import org.example.backend.dto.AdminDto;
import org.example.backend.dto.TeacherDto;
import org.example.backend.repository.AdminRepository;
import org.example.backend.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private AdminRepository adminRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setAdminRepository(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<AdminDto> getAdmins() {
        return adminRepository.findAll().stream().map((e) -> modelMapper.map(e, AdminDto.class)).toList();
    }

}
