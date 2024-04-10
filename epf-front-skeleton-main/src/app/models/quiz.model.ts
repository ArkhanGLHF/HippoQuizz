import { Question } from "./question.model"

export interface Quiz {
    id: bigint
    title: string
    description: string
    questions: Question[]
  }