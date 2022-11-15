import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-project-item',
  templateUrl: './project-item.component.html',
  styleUrls: ['./project-item.component.css']
})
export class ProjectItemComponent implements OnInit {

  @Input() title = "";
  @Input() company = "";
  @Input() date = "";
  @Input() picture = "";
  @Input() resume = "";
  @Input() link = "";

  constructor() { }

  ngOnInit(): void {
  }

}
