import { Quiz } from "./quiz.model"

export interface Question {
  id?: bigint
  questionText: string
  questionPicture: string
  quiz: Quiz
}
