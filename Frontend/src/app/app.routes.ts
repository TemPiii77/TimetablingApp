import { Routes } from '@angular/router';
import {HomepageComponent} from "./homepage/homepage.component";
import {LoginComponent} from "./auth/login/login.component";
import {SubjectContainerComponent} from "./subjectManagement/subject-container/subject-container.component";
import {PreferredTimeContainerComponent} from "./preferredTimeManagement/preferred-time-container/preferred-time-container.component";
import {TimeslotComponent} from "./timeslotManagement/timeslot/timeslot.component";
import {ClassContainerComponent} from "./classManagement/class-container/class-container.component";
import {ClassroomComponent} from "./classroomManagement/classroom/classroom.component";
import {SceneContainerComponent} from "./sceneManagement/scene-container/scene-container.component";
import {UserContainerComponent} from "./userManagement/user-container/user-container.component";
import {ProfileComponent} from "./profile/profile.component";

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
    title: 'Főoldal',
    component: HomepageComponent,
  },
  {
    path: 'profile',
    title: '',
    component: ProfileComponent,
  },
  {
    path: 'user',
    title: '',
    component: UserContainerComponent,
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
