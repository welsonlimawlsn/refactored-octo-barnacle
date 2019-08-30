import {Component, Input, OnInit} from '@angular/core';
import {Personagem} from "../personagem.model";

@Component({
  selector: 'hr-personagem',
  templateUrl: './personagem.component.html',
  styleUrls: ['./personagem.component.css']
})
export class PersonagemComponent implements OnInit {

  @Input()
  personagem: Personagem;

  @Input()
  titulo: string;

  constructor() {
  }

  ngOnInit() {
  }

}
