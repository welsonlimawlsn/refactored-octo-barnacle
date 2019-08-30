import {Component, Input, OnInit} from '@angular/core';
import {Partida} from "../partida.model";

@Component({
  selector: 'hr-partida',
  templateUrl: './partida.component.html',
  styleUrls: ['./partida.component.css']
})
export class PartidaComponent implements OnInit {

  @Input()
  partida: Partida;

  @Input()
  link: boolean;

  constructor() {
  }

  ngOnInit() {
  }

}
