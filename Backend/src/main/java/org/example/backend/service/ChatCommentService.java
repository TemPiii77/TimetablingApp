package org.example.backend.service;

import org.example.backend.domain.ChatComment;
import org.example.backend.domain.Grade;
import org.example.backend.dto.ChatCommentDto;
import org.example.backend.dto.GradeDto;
import org.example.backend.repository.ChatCommentRepository;
import org.example.backend.repository.GradeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatCommentService {

    private ChatCommentRepository chatCommentRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setChatCommentRepository(ChatCommentRepository chatCommentRepository) {
        this.chatCommentRepository = chatCommentRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<ChatCommentDto> getChatComments() {
        return chatCommentRepository.findAll().stream().map((e) -> modelMapper.map(e, ChatCommentDto.class)).toList();
    }

    public ChatCommentDto getChatComment(Integer id) {
        return chatCommentRepository.findById(id).map((e) -> modelMapper.map(e, ChatCommentDto.class)).orElse(null);
    }

    public void saveChatComment(ChatCommentDto chatCommentDto) {
        ChatComment chatComment = modelMapper.map(chatCommentDto, ChatComment.class);
        chatCommentRepository.save(chatComment);
    }

    public void updateChatComment(ChatCommentDto chatCommentDto) {
        ChatComment chatComment = modelMapper.map(chatCommentDto, ChatComment.class);
        chatCommentRepository.save(chatComment);
    }

    public void deleteChatComment(Integer id) {
        chatCommentRepository.deleteById(id);
    }

}
