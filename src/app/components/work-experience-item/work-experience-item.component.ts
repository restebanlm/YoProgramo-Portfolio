import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-work-experience-item',
  templateUrl: './work-experience-item.component.html',
  styleUrls: ['./work-experience-item.component.css']
})
export class WorkExperienceItemComponent implements OnInit {

  logo = "";
  positionTitle = "Desarrollador Jr";
  company = "Tribunal Superior de Justicia";
  typeOfWorkingDay = "Parcial";
  dateFrom = "27-05-2020";
  dateTo = "Actualidad";
  resume = "...";

  constructor() { }

  ngOnInit(): void {
  }

}
