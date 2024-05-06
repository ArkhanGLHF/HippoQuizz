import { NgModule } from "@angular/core"
import { RouterModule, Routes } from "@angular/router"
import { HomeComponent } from "home/home.component"
import { StudentsComponent } from "students/students.component"
import { StudentsResolver } from "students/students.resolver"
import { StudentDetailsComponent } from "students/student-details/student-details.component"
import { StudentDetailsResolver } from "students/student-details/student-details.resolver"
import { MajorsComponent } from "majors/majors.component"
import { MajorsResolver } from "majors/majors.resolver"
import { MajorStudentsResolver } from "majors/major-students/major-students.resolver"
import { MajorStudentsComponent } from "majors/major-students/major-students.component"
import { LoginComponent } from "login/login.component"
import { LoginResolver } from "login/login.resolver"
import { QuestionsComponent } from "questions/questions.component"
import { QuizComponent } from "quiz/quiz.component"
import { QuizDetailsComponent } from "quiz/quiz-details/quiz-details.component"
import { UsersComponent } from "users/users.component"
import { UserDetailsComponent } from "users/user-details/user-details.component"
import { UserNewComponent } from "users/user-new/user-new.component"
import { ResultsComponent } from "results/results.component"
import { ResultDetailsComponent } from "results/result-details/result-details.component"
import { AdminComponent } from "admin/admin.component"

const routes: Routes = [
  { path: "", component: HomeComponent },
  {
    path: "students",
    component: StudentsComponent,
    resolve: {
      students: StudentsResolver,
    },
  },
  {
    path: "student-details/:id",
    component: StudentDetailsComponent,
    resolve: {
      student: StudentDetailsResolver,
    },
  },
  {
    path: "majors",
    component: MajorsComponent,
    resolve: {
      majors: MajorsResolver,
    },
  },
  {
    path: "major-students/:id",
    component: MajorStudentsComponent,
    resolve: {
      studentsFromMajor: MajorStudentsResolver,
    },
  },
  {
    path: "login",
    component: LoginComponent,
    resolve: {
      login: LoginResolver,
    },
  },
  {
    path: "questions",
    component: QuestionsComponent,
  },
  {
    path: "quiz",
    component: QuizComponent,
  },
  {
    path: "quiz-details/:id",
    component: QuizDetailsComponent,
  },
  {
    path: "users",
    component: UsersComponent,
  },
  {
    path: "user-details/:id",
    component: UserDetailsComponent,
  },
  {
    path: "user-new",
    component: UserNewComponent,
  },
  {
    path: "results",
    component: ResultsComponent,
  },
  {
    path: "result-details/:id",
    component: ResultDetailsComponent,
  },
  {
    path: "admin",
    component: AdminComponent,
  }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
