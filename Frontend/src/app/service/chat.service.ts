import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {ChatDto} from "../dto/chat-dto";
import {AuthService} from "./auth.service";
import {UserDto} from "../dto/user-dto";
import {AbsenceDto} from "../dto/absence-dto";

@Injectable({
  providedIn: 'root'
})
export class ChatService {

  private chatsSubject = new BehaviorSubject<ChatDto[]>([]);
  chats$ = this.chatsSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listChats(): void {
    this.http.get<ChatDto[]>("http://localhost:8080/admin/chat", {headers: this.authService.headers}).subscribe(resultData => {
      this.chatsSubject.next(resultData);
    });
  }

  listUsersChats(user: UserDto): void {
    this.http.post<ChatDto[]>(`http://localhost:8080/usersChats`, user,  {headers: this.authService.headers}).subscribe(resultData => {
      this.chatsSubject.next(resultData);
    });
  }

  saveChat(newChat: ChatDto): void {
    this.http.post<ChatDto>("http://localhost:8080/admin/chat", newChat, {headers: this.authService.headers}).subscribe(() => {
      this.listChats();
    });
  }

  deleteChat(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/chat/${id}`, {headers: this.authService.headers});
  }

  updateChat(updatedChat: ChatDto): void {
    this.http.put<ChatDto>("http://localhost:8080/admin/chat", updatedChat, {headers: this.authService.headers}).subscribe(() => {
      this.listChats();
    });
  }
}
