import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {UserChatDto} from "../dto/user-chat-dto";
import {UserChatIdDto} from "../dto/user-chat-id-dto";

@Injectable({
  providedIn: 'root'
})
export class UserChatService {

  private userChatsSubject = new BehaviorSubject<UserChatDto[]>([]);
  userChats$ = this.userChatsSubject.asObservable();

  constructor(private http: HttpClient) {}

  listUserChats(): void {
    this.http.get<UserChatDto[]>("http://localhost:8080/admin/userChat").subscribe(resultData => {
      this.userChatsSubject.next(resultData);
    });
  }

  saveUserChat(newUserChatId: UserChatIdDto): void {
    this.http.post<UserChatIdDto>("http://localhost:8080/admin/userChat", newUserChatId).subscribe(() => {
      this.listUserChats();
    });
  }

  deleteUserChat(userId: string, chatId: number ): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/userChat/${userId}_${chatId}`);
  }

  updateUserChat(updatedUserChatId: UserChatIdDto): void {
    this.http.put<UserChatIdDto>("http://localhost:8080/admin/userChat", updatedUserChatId).subscribe(() => {
      this.listUserChats();
    });
  }
}
