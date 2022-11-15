import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  sesion = true;

  constructor() { }

  ngOnInit(): void {
  }

  changeSesion() {
    this.sesion = !this.sesion;
    console.log(this.sesion);
  }
}
