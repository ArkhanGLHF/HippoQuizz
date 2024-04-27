import { Quiz } from "./quiz.model"
import { User } from "./user.model"

export interface Result {
  id?: bigint
  score: bigint
  dateCompleted: Date
  user : User
  quiz: Quiz
}