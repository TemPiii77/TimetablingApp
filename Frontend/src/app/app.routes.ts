import { Routes } from '@angular/router';
import {HomepageComponent} from "./homepage/homepage.component";
import {LoginComponent} from "./auth/login/login.component";
import {UserManagementComponent} from "./user/user-management/user-management.component";
import {SubjectContainerComponent} from "./subjectManagement/subject-container/subject-container.component";
import {PreferredTimeContainerComponent} from "./preferredTimeManagement/preferred-time-container/preferred-time-container.component";
import {TimeslotComponent} from "./timeslotManagement/timeslot/timeslot.component";
import {ClassContainerComponent} from "./classManagement/class-container/class-container.component";
import {ClassroomComponent} from "./classroomManagement/classroom/classroom.component";
import {SceneContainerComponent} from "./sceneManagement/scene-container/scene-container.component";

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
    component: SubjectContainerComponent,
  },
  {
    path: 'classroom',
    title: '',
    component: ClassroomComponent,
  },
  {
    path: 'class',
    title: '',
    component: ClassContainerComponent,
  },
  {
    path: 'preferredTime',
    title: '',
    component: PreferredTimeContainerComponent,
  },
  {
    path: 'timeslot',
    title: '',
    component: TimeslotComponent,
  },
  {
    path: 'forum',
    title: '',
    component: SceneContainerComponent,
  },








];
