import { NgModule } from "@angular/core"
import { BrowserModule } from "@angular/platform-browser"

import { AppRoutingModule } from "app-routing.module"
import { AppComponent } from "app.component"
import { BrowserAnimationsModule } from "@angular/platform-browser/animations"
import { NavbarComponent } from "navbar/navbar.component"
import { MatListModule } from "@angular/material/list"
import { HomeComponent } from "home/home.component"
import { StudentsComponent } from "students/students.component"
import { StudentDetailsComponent } from "students/student-details/student-details.component"
import { FormsModule } from "@angular/forms"
import { MatIconModule } from "@angular/material/icon"
import { MatButtonModule } from "@angular/material/button"
import { MajorsComponent } from "majors/majors.component"
import { MajorStudentsComponent } from "majors/major-students/major-students.component"
import { HttpClientModule } from "@angular/common/http"
import { LoginComponent } from './login/login.component'
import {MatCardModule} from '@angular/material/card'
import {MatFormFieldModule} from '@angular/material/form-field';
import { QuestionsComponent } from './questions/questions.component';
import { QuizComponent } from './quiz/quiz.component';
import { QuizDetailsComponent } from './quiz/quiz-details/quiz-details.component';
import { UsersComponent } from './users/users.component';
import { UserDetailsComponent } from './users/user-details/user-details.component';
import { UserNewComponent } from './users/user-new/user-new.component';
import { QuizNewComponent } from './quiz/quiz-new/quiz-new.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    StudentsComponent,
    StudentDetailsComponent,
    MajorsComponent,
    MajorStudentsComponent,
    LoginComponent,
    QuestionsComponent,
    QuizComponent,
    QuizDetailsComponent,
    UsersComponent,
    UserDetailsComponent,
    UserNewComponent,
    QuizNewComponent,
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
