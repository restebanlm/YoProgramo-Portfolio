import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: ['./education.component.css']
})
export class EducationComponent implements OnInit {
  logo = "";
  degree = "Licenciatura en Sistemas";
  college = "Universidad Nacional de La Rioja";
  dateFrom = "27-05-2020";
  dateTo = "Actualidad";

  constructor() { }

  ngOnInit(): void {
  }

}
