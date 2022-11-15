import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { usuario } from '../model/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  URL = 'http://localhost:8080/api/portfolio/usuario/';

  constructor(private http: HttpClient) { }

  public getPersona(): Observable<usuario> {
    return this.http.get<usuario>(this.URL + 'get/1')
  }

}
