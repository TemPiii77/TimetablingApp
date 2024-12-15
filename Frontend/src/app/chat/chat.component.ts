import { Component } from '@angular/core';
import {ChatDto} from "../dto/chat-dto";
import {ClassService} from "../service/class.service";
import {AbsenceService} from "../service/absence.service";
import {AuthService} from "../service/auth.service";
import {ChatService} from "../service/chat.service";
import {DatePipe} from "@angular/common";
import {ChatCommentService} from "../service/chat-comment.service";
import {ChatCommentDto} from "../dto/chat-comment-dto";

@Component({
  selector: 'app-chat',
  standalone: true,
  imports: [
    DatePipe
  ],
  templateUrl: './chat.component.html',
  styleUrl: './chat.component.css'
})
export class ChatComponent {

  chats: ChatDto[] = [];
  chatComments: ChatCommentDto[] = [];


  constructor(private chatService: ChatService,
              private chatCommentService: ChatCommentService,
              private authService: AuthService) {}

  ngOnInit(): void {
    // @ts-ignore
    this.authService.currentUser.subscribe(user => {
      this.chatService.listUsersChats(user);
    });

    this.chatService.chats$.subscribe(resultData => {
      this.chats = resultData;
    });
  }

  handleSubmit(chatId: number) {

    // @ts-ignore
    this.authService.currentUser.subscribe(user => {
      this.chatCommentService.listUsersChatComments(chatId);
    });

    this.chatCommentService.chatComments$.subscribe(resultData => {
      this.chatComments = resultData;
    });
  }

  getTimestampInMilliseconds(dateRecorded: Date | undefined): number {
    return Number(dateRecorded) * 1000;
  }
}
