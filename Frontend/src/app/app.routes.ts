import { Routes } from '@angular/router';
import {HomepageComponent} from "./homepage/homepage.component";
import {LoginComponent} from "./auth/login/login.component";
import {UserManagementComponent} from "./user/user-management/user-management.component";
import {SubjectManagementComponent} from "./subject/subject-management/subject-management.component";
import {ClassManagementComponent} from "./class/class-management/class-management.component";
import {PreferredTimeManagementComponent} from "./preferredTime/preferred-time-management/preferred-time-management.component";
import {TimeslotManagementComponent} from "./timeslot/timeslot-management/timeslot-management.component";
import {ClassroomManagementComponent} from "./classroom/classroom-management/classroom-management.component";

export const routes: Routes = [
  {
    path: '',
    title: 'Bejelentkezés',
    component: LoginComponent,
    pathMatch: 'full'
  },
  {
    path: 'login',
    title: 'Bejelentkezés',
    component: LoginComponent,
  },
  {
    path: 'home',
    title: '',
    component: HomepageComponent,
  },
  {
    path: 'user',
    title: '',
    component: UserManagementComponent,
  },
  {
    path: 'subject',
    title: '',
    component: SubjectManagementComponent,
  },
  {
    path: 'classroom',
    title: '',
    component: ClassroomManagementComponent,
  },
  {
    path: 'class',
    title: '',
    component: ClassManagementComponent,
  },
  {
    path: 'preferredTime',
    title: '',
    component: PreferredTimeManagementComponent,
  },
  {
    path: 'timeslot',
    title: '',
    component: TimeslotManagementComponent,
  }









];
