import { NgModule } from "@angular/core"
import { RouterModule, Routes } from "@angular/router"
import { HomeComponent } from "home/home.component"
import { QuestionsComponent } from "questions/questions.component"
import { QuizComponent } from "quiz/quiz.component"
import { QuizDetailsComponent } from "quiz/quiz-details/quiz-details.component"
import { QuizConfigurationComponent } from "quiz/quiz-configuration/quiz-configuration.component"
import { QuizConfigurationDetailsComponent } from "quiz/quiz-configuration/quiz-configuration-details/quiz-configuration-details.component"
import { QuizConfigurationNewComponent } from "quiz/quiz-configuration/quiz-configuration-new/quiz-configuration-new.component"
import { UsersComponent } from "users/users.component"
import { UserDetailsComponent } from "users/user-details/user-details.component"
import { UserNewComponent } from "users/user-new/user-new.component"
import { ResultsComponent } from "results/results.component"
import { ResultDetailsComponent } from "results/result-details/result-details.component"
import { AdminComponent } from "admin/admin.component"

import { QuestionDetailsComponent } from "questions/question-details/question-details.component"

const routes: Routes = [
  { path: "", component: HomeComponent },
  {
    path: "questions",
    component: QuestionsComponent,
  },
  {
    path: "question-details/:id",
    component: QuestionDetailsComponent,
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
    path: "quiz-configuration",
    component: QuizConfigurationComponent
  },
  {
    path: "quiz-configuration-details/:id",
    component: QuizConfigurationDetailsComponent
  },
  {
    path: "quiz-configuration-new",
    component: QuizConfigurationNewComponent
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
