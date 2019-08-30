import {Injectable} from '@angular/core';
import {Personagem} from "./personagem.model";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PersonagemService {

  constructor(private http: HttpClient) {
  }

  cadastraNovoPersonagem(personagem: Personagem): Observable<any> {
    return this.http.post(`${environment.apiUrl}/personagem`, personagem);
  }
}
