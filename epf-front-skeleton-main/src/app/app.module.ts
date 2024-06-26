import { NgModule } from "@angular/core"
import { BrowserModule } from "@angular/platform-browser"

import { AppRoutingModule } from "app-routing.module"
import { AppComponent } from "app.component"
import { BrowserAnimationsModule } from "@angular/platform-browser/animations"
import { NavbarComponent } from "navbar/navbar.component"
import { MatListModule } from "@angular/material/list"
import { HomeComponent } from "home/home.component"
import { FormsModule } from "@angular/forms"
import { MatIconModule } from "@angular/material/icon"
import { MatButtonModule } from "@angular/material/button"
import { HttpClientModule } from "@angular/common/http"
import {MatCardModule} from '@angular/material/card'
import {MatFormFieldModule} from '@angular/material/form-field';
import { QuestionsComponent } from './questions/questions.component';
import { QuestionDetailsComponent } from './questions/question-details/question-details.component';
import { QuizComponent } from './quiz/quiz.component';
import { QuizDetailsComponent } from './quiz/quiz-details/quiz-details.component';
import { UsersComponent } from './users/users.component';
import { UserDetailsComponent } from './users/user-details/user-details.component';
import { UserNewComponent } from './users/user-new/user-new.component';
import { ResultsComponent } from './results/results.component';
import { ResultDetailsComponent } from './results/result-details/result-details.component';
import { AdminComponent } from './admin/admin.component';
import { QuizConfigurationComponent } from "quiz/quiz-configuration/quiz-configuration.component"
import { QuizConfigurationDetailsComponent } from "quiz/quiz-configuration/quiz-configuration-details/quiz-configuration-details.component"
import { QuizConfigurationNewComponent } from "quiz/quiz-configuration/quiz-configuration-new/quiz-configuration-new.component"

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    QuestionsComponent,
    QuestionDetailsComponent,
    QuizComponent,
    QuizDetailsComponent,
    UsersComponent,
    UserDetailsComponent,
    UserNewComponent,
    ResultsComponent,
    ResultDetailsComponent,
    AdminComponent,
    QuizConfigurationComponent,
    QuizConfigurationDetailsComponent,
    QuizConfigurationNewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatListModule,
    FormsModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {
}
