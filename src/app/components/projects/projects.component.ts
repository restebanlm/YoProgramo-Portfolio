import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {

  title = "Aplicación de Realidad Virtual";
  company = "Museo Histórico JVG";
  date = "27/05/2020";
  picture = "-";
  resume = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolore porro aperiam cupiditate repudiandae, sed voluptatum ducimus, impedit consequuntur a labore natus suscipit, rem inventore soluta fugit eveniet delectus repellendus eligendi.";
  link = "https://www.youtube.com";
  constructor() { }

  ngOnInit(): void {
  }

}
