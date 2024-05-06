import { Component, OnInit } from "@angular/core"
import { Link } from "models/links.model"

@Component({
  selector: "epf-navbar",
  templateUrl: "./navbar.component.html",
  styleUrls: ["./navbar.component.scss"],
})
export class NavbarComponent {
  links: Link[] = []

  constructor() {
    /*this.links.push({ name: "Quiz", href: "quiz" })
    this.links.push({ name: "Students", href: "students" })
    this.links.push({ name: "Majors", href: "majors" })
    this.links.push({ name: "Login", href: "login" })
    this.links.push({ name: "Users", href: "users" })
    this.links.push({ name: "Questions", href: "questions" })
    this.links.push({ name: "Results", href: "results" })*/
  }
}
