import { Quiz } from "./quiz.model"
import { User } from "./user.model"

export interface Result {
  id?: bigint
  user : User
  quiz: Quiz
  score: number
  dateCompleted: Date
}
