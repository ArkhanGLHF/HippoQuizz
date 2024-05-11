import { Quiz } from "./quiz.model"

export interface Question {
  id?: bigint
  quiz: Quiz
  questionText: string
  questionPicture: string
  questionAnswer : boolean
}
