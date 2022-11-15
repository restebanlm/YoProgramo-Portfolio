import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hard-soft-skills',
  templateUrl: './hard-soft-skills.component.html',
  styleUrls: ['./hard-soft-skills.component.css']
})
export class HardSoftSkillsComponent implements OnInit {

  abilities = "Java";
  value = 70;
  language = "Español";
  level = "C1";

  constructor() { }

  ngOnInit(): void {
  }

}
