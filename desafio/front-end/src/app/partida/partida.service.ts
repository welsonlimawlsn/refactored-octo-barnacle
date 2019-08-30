import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {Partida} from "./partida.model";
import {tap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class PartidaService {

  constructor(private http: HttpClient) {
  }

  novaPartida(): Observable<any> {
    return this.http.post<any>(`${environment.apiUrl}/partida`, null, {observe: 'response'});
  }

  consultaPartidaPorURL(url: string): Observable<Partida> {
    return this.http.get<Partida>(url).pipe(tap(partida => console.log(partida)));
  }

  consultaPartidaPorId(id: string): Observable<Partida> {
    return this.http.get<Partida>(`${environment.apiUrl}/partida/${id}`);
  }

  listaTodas(): Observable<Partida[]> {
    return this.http.get<Partida[]>(`${environment.apiUrl}/partida`);
  }
}
