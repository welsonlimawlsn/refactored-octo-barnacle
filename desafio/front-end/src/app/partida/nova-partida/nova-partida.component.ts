import {Component, OnInit} from '@angular/core';
import {PartidaService} from "../partida.service";
import {Partida} from "../partida.model";
import {flatMap} from "rxjs/operators";

@Component({
  selector: 'hr-nova-partida',
  templateUrl: './nova-partida.component.html',
  styleUrls: ['./nova-partida.component.css']
})
export class NovaPartidaComponent implements OnInit {

  partida: Partida;

  constructor(private partidaService: PartidaService) {
  }

  ngOnInit() {
  }

  novaPartida() {
    this.partidaService.novaPartida()
      .pipe(
        flatMap((response) => this.partidaService.consultaPartidaPorURL(response.headers.get('Location')))
      ).subscribe(partida => this.partida = partida);
  }
}
