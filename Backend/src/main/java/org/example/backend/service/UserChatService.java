package org.example.backend.service;

import org.example.backend.domain.*;
import org.example.backend.domain.Class;
import org.example.backend.dto.ClassSceneDto;
import org.example.backend.dto.ClassSceneIdDto;
import org.example.backend.dto.UserChatDto;
import org.example.backend.dto.UserChatIdDto;
import org.example.backend.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserChatService {

    private UserChatRepository userChatRepository;
    private ModelMapper modelMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChatRepository chatRepository;

    @Autowired
    public void setUserChatRepository(UserChatRepository userChatRepository) {
        this.userChatRepository = userChatRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<UserChatDto> getUserChats() {
        return userChatRepository.findAll().stream().map((e) -> modelMapper.map(e, UserChatDto.class)).toList();
    }

    public UserChatDto getUserChat(String userId, Integer chatId) {
        UserChatId userChatId = new UserChatId(userId, chatId);
        return userChatRepository.findById(userChatId).map((e) -> modelMapper.map(e, UserChatDto.class)).orElse(null);
    }

    public void saveUserChat(UserChatIdDto userChatIdDto) {
        UserChatId userChatId = modelMapper.map(userChatIdDto, UserChatId.class);

        User user = userRepository.findById(userChatId.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        Chat chat = chatRepository.findById(userChatId.getChatId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid chat ID"));

        UserChat userChat = new UserChat();
        userChat.setUser(user);
        userChat.setChat(chat);

        userChat.setId(userChatId);

        userChatRepository.save(userChat);
    }

    public void updateUserChat(UserChatIdDto userChatIdDto) {
        UserChatId userChatId = modelMapper.map(userChatIdDto, UserChatId.class);

        User user = userRepository.findById(userChatId.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        Chat chat = chatRepository.findById(userChatId.getChatId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid chat ID"));

        UserChat userChat = new UserChat();
        userChat.setUser(user);
        userChat.setChat(chat);

        userChat.setId(userChatId);

        userChatRepository.save(userChat);
    }


    public void deleteUserChat(String userId, Integer chatId) {
        UserChatId userChatId = new UserChatId(userId, chatId);
        userChatRepository.deleteById(userChatId);
    }

}
