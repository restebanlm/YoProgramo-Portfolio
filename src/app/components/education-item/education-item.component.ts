import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-education-item',
  templateUrl: './education-item.component.html',
  styleUrls: ['./education-item.component.css']
})
export class EducationItemComponent implements OnInit {

  title = "Lic en Sistemas de Información";
  company = "UNLaR";
  dateFrom = "27-05-2012";
  dateTo = "27-05-2020";
  average = 8.15;

  constructor() { }

  ngOnInit(): void {
  }

}
