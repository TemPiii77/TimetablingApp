import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {ChatCommentDto} from "../dto/chat-comment-dto";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class ChatCommentService {

  private chatCommentsSubject = new BehaviorSubject<ChatCommentDto[]>([]);
  chatComments$ = this.chatCommentsSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listChatComments(): void {
    this.http.get<ChatCommentDto[]>("http://localhost:8080/admin/chatComment", {headers: this.authService.headers}).subscribe(resultData => {
      this.chatCommentsSubject.next(resultData);
    });
  }

  saveChatComment(newChatComment: ChatCommentDto): void {
    this.http.post<ChatCommentDto>("http://localhost:8080/admin/chatComment", newChatComment, {headers: this.authService.headers}).subscribe(() => {
      this.listChatComments();
    });
  }

  deleteChatComment(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/chatComment/${id}`, {headers: this.authService.headers});
  }

  updateChatComment(updatedChatComment: ChatCommentDto): void {
    this.http.put<ChatCommentDto>("http://localhost:8080/admin/chatComment", updatedChatComment, {headers: this.authService.headers}).subscribe(() => {
      this.listChatComments();
    });
  }
}
