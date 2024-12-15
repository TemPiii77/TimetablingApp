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
import {SceneDisplayComponent} from "./sceneManagement/scene-display/scene-display.component";
import {ScenePartDisplayComponent} from "./sceneManagement/scene-part-display/scene-part-display.component";
import {SceneCommentDisplayComponent} from "./sceneManagement/scene-comment-display/scene-comment-display.component";
import {GradeComponent} from "./records/grade/grade.component";
import {AbsenceComponent} from "./records/absence/absence.component";
import {DelayComponent} from "./records/delay/delay.component";
import {ProblemComponent} from "./records/problem/problem.component";
import {SubjectDisplayComponent} from "./subjectManagement/subject-display/subject-display.component";
import {TimetableComponent} from "./timeslotManagement/timetable/timetable.component";

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
    path: 'subjects',
    title: '',
    component: SubjectDisplayComponent,
  },
  {
    path: 'subjects/:selectedClassId/:subjectId',
    title: '',
    component: GradeComponent,
  },
  {
    path: 'absences',
    title: '',
    component: AbsenceComponent,
  },
  {
    path: 'delays',
    title: '',
    component: DelayComponent,
  },
  {
    path: 'problems',
    title: '',
    component: ProblemComponent,
  },
  {
    path: 'timetable',
    title: '',
    component: TimetableComponent,
  },
  {
    path: 'forum_',
    title: '',
    component: SceneContainerComponent,
  },
  {
    path: 'forum',
    title: '',
    component: SceneDisplayComponent,
  },
  {
    path: 'forum/:sceneId',
    title: '',
    component: ScenePartDisplayComponent,
  },
  {
    path: 'forum/:sceneId/:id',
    title: '',
    component: SceneCommentDisplayComponent,
  },

  {
    path: 'chat',
    title: '',
    component: SceneDisplayComponent,
  },








];
