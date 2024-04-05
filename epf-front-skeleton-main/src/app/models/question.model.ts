import { Course } from "./course.model"
import { Major } from "./major.model"

// IMPORT QUIZ MODEL WHEN IT WILL BE CREATED
// import { Quiz } from "./quiz.model"

export interface Question {
  id?: bigint
  questionText: string
  questionPicture: string
  //Uncomment when Quiz model will be created
  //quiz: Quiz
}
