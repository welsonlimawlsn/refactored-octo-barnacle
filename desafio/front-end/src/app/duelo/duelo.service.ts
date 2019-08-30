import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Duelo} from "./duelo.model";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class DueloService {

  constructor(private http: HttpClient) {
  }

  consultaDueloPorPartida(idPartida: string): Observable<Duelo[]> {
    return this.http.get<Duelo[]>(`${environment.apiUrl}/partida/${idPartida}/duelos`);
  }
}
