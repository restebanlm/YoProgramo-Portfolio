import { Component, OnInit } from '@angular/core';
import { persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-about-me',
  templateUrl: './about-me.component.html',
  styleUrls: ['./about-me.component.css']
})
export class AboutMeComponent implements OnInit {

  persona: persona = new persona("", "", "")

  residence = "La Rioja - Argentina";
  job = "Fullstack Developer Jr";
  abstract = "Licenciado en Economía, trader, analista de mercado de capitales , analista de datos con python y Power BI. Creador y administrador del grupo de análisis y debate financiero mas grande de la Universidad Nacional de San Martín.";

  constructor(public personaService: PersonaService) {

  }

  ngOnInit(): void {
    this.personaService.getPersona().subscribe(data => { this.persona = data })
  }

}
