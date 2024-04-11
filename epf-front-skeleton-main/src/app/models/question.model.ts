import { Quiz } from "./quiz.model"

export interface Question {
  id?: bigint
  questionText: string
  questionPicture: string
  questionAnswer : boolean
  quiz: Quiz
}
