import {Component, OnInit} from '@angular/core';
import {PensionerBusinessService} from "../business.service";
import {FireLoginService} from "../../commons/fire-login/fire-login.service";

@Component({
  selector: 'app-pensioner-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.less']
})
export class PensionerFormComponent implements OnInit {

  public parameters: any = {};
  public profession = [];

  public countryOptions: Array<any> = [
    {
      'id': "Colombia",
      'name': "Colombia"
    },
    {
      'id': "Exterior",
      'name': "Exterior"
    }
  ];

  constructor(public fireLoginService :FireLoginService,
              public businessService: PensionerBusinessService) {
  }

  ngOnInit() {
    var userData = this.fireLoginService.getUserData();
    var tipopagador = userData.superEntity.tipoPagador.id || 1;
    this.businessService.getParameters('/parameters/tipopagador/'+tipopagador+'/opciones').subscribe((response: any) => {
      this.parameters = response;
    });
  }

  public getPensionerOptions() {
    var key = this.businessService.selectedRow.tipoPension || "0";
    if (this.parameters.values) {
      return this.parameters.values.pensionPensionado[key];
    }
    return [];
  }

  public getPensionOptions() {
    var key = this.businessService.selectedRow.tipoPensionado || "0";
    if (this.parameters.values) {
      return this.parameters.values.pensionadoPension[key];
    }
    return [];
  }

  public save() {
    var row = this.businessService.selectedRow;
    row.superEntityId =this.fireLoginService.getUserData().superEntity.id;
    this.businessService.save(row);
  }

  public update() {
    var row = this.businessService.selectedRow;
    row.superEntityId =this.fireLoginService.getUserData().superEntity.id;
    this.businessService.update(row);
  }

  public delete() {
    this.businessService.delete(this.businessService.selectedRow);
  }

}
