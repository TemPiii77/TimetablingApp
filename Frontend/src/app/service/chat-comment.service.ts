import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {ChatCommentDto} from "../dto/chat-comment-dto";

@Injectable({
  providedIn: 'root'
})
export class ChatCommentService {

  private chatCommentsSubject = new BehaviorSubject<ChatCommentDto[]>([]);
  chatComments$ = this.chatCommentsSubject.asObservable();

  constructor(private http: HttpClient) {}

  listChatComments(): void {
    this.http.get<ChatCommentDto[]>("http://localhost:8080/admin/chatComment").subscribe(resultData => {
      this.chatCommentsSubject.next(resultData);
    });
  }

  saveChatComment(newChatComment: ChatCommentDto): void {
    this.http.post<ChatCommentDto>("http://localhost:8080/admin/chatComment", newChatComment).subscribe(() => {
      this.listChatComments();
    });
  }

  deleteChatComment(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/chatComment/${id}`);
  }

  updateChatComment(updatedChatComment: ChatCommentDto): void {
    this.http.put<ChatCommentDto>("http://localhost:8080/admin/chatComment", updatedChatComment).subscribe(() => {
      this.listChatComments();
    });
  }
}
