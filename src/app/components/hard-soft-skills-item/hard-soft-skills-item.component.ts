import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-hard-soft-skills-item',
  templateUrl: './hard-soft-skills-item.component.html',
  styleUrls: ['./hard-soft-skills-item.component.css']
})
export class HardSoftSkillsItemComponent implements OnInit {

  @Input() abilities = '';
  @Input() value = 0;
  constructor() { }

  ngOnInit(): void {
  }

}
