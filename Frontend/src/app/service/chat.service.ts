import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {ChatDto} from "../dto/chat-dto";

@Injectable({
  providedIn: 'root'
})
export class ChatService {

  private chatsSubject = new BehaviorSubject<ChatDto[]>([]);
  chats$ = this.chatsSubject.asObservable();

  constructor(private http: HttpClient) {}

  listChats(): void {
    this.http.get<ChatDto[]>("http://localhost:8080/admin/chat").subscribe(resultData => {
      this.chatsSubject.next(resultData);
    });
  }

  saveChat(newChat: ChatDto): void {
    this.http.post<ChatDto>("http://localhost:8080/admin/chat", newChat).subscribe(() => {
      this.listChats();
    });
  }

  deleteChat(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/chat/${id}`);
  }

  updateChat(updatedChat: ChatDto): void {
    this.http.put<ChatDto>("http://localhost:8080/admin/chat", updatedChat).subscribe(() => {
      this.listChats();
    });
  }
}
