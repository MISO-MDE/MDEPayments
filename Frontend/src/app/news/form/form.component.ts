import { Component, OnInit } from '@angular/core';
import {PensionerApiService} from '../../pensioner/rest.api.service';
import {NewsBusinessService} from "../business.service";
import { INews } from "../../commons/sharedresources/interfaces"

@Component({
  selector: 'app-new-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.less']
})
export class NewFormComponent implements OnInit {

    public tipoNovedad = [
      {id: '1', name: 'Traslado'},
      {id: '2', name: 'Variación transitoria del salario'},
      {id: '3', name: 'Suspension temporal, licencia no remunerada o comosión de servicios'},
      {id: '4', name: 'Incapacidad temporal por enfermedad'},
      {id: '5', name: 'Licencia de maternidad o paternidad'},
      {id: '6', name: 'Vacaciones'},
      {id: '7', name: 'Licencia remunerada'},
      {id: '8', name: 'Aporte voluntario a pensiones'},
      {id: '9', name: 'Suspension'}
    ];

  public entity = {};

  constructor(private pensionerService: PensionerApiService,
              public businessService: NewsBusinessService) { }

  ngOnInit() {
  }

  getEntity() {
    this.pensionerService.loadById(this.businessService.selectedEntity.cedula).subscribe((entityObj:any) => {
      this.businessService.selectedEntity = entityObj;
    });
    this.businessService.loadEvents(this.businessService.selectedEntity.cedula);
  }

  public saveNews() {
    this.businessService.saveNews(<INews>this.businessService.selectedRow);
  }

}
