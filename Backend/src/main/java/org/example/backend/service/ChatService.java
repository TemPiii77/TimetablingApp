package org.example.backend.service;

import org.example.backend.domain.Chat;
import org.example.backend.domain.Classroom;
import org.example.backend.domain.User;
import org.example.backend.dto.*;
import org.example.backend.repository.ChatRepository;
import org.example.backend.repository.ClassroomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    private ChatRepository chatRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setChatRepository(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<ChatDto> getChats() {
        return chatRepository.findAll().stream().map((e) -> modelMapper.map(e, ChatDto.class)).toList();
    }

    public ChatDto getChat(Integer id) {
        return chatRepository.findById(id).map((e) -> modelMapper.map(e, ChatDto.class)).orElse(null);
    }

    public void saveChat(ChatDto chatDto) {
        Chat chat = modelMapper.map(chatDto, Chat.class);
        chatRepository.save(chat);
    }

    public void updateChat(ChatDto chatDto) {
        Chat chat = modelMapper.map(chatDto, Chat.class);
        chatRepository.save(chat);
    }

    public void deleteChat(Integer id) {
        chatRepository.deleteById(id);
    }

    public List<ChatDto> getUsersChats(UserDto userDto) {
        return chatRepository.findUsersChats(userDto.getId()).stream().map((e) -> modelMapper.map(e, ChatDto.class)).toList();
    }
}
