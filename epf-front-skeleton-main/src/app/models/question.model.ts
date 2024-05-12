import { Quiz } from "./quiz.model"

export interface Question {
  id?: bigint
  questionText: string
  questionAnswer : boolean
  quiz: Quiz
}
