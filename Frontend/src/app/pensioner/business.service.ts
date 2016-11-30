import {Injectable} from '@angular/core';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {PensionerApiService} from "./rest.api.service";
import {ToasterService, Toast} from 'angular2-toaster/angular2-toaster';

@Injectable()
export class PensionerBusinessService {

  public rows: Array<any>;

  public columns: Array<any> = [
    {title: 'Nombre', className: 'text-warning', name: 'nombre'},
    {title: 'Apellido', className: 'text-warning', name: 'apellido'},
    {title: 'Identificación', name: 'cedula'},
    {title: 'Salario', name: 'salario'}
  ];
  public selectedRow: any = {};

  constructor(private restApiService: PensionerApiService,
              private toasterService: ToasterService) {
  }

  /********************************* Crud operations  *************************************/
  public loadList(): any {
    this.restApiService.loadList('*')
      .subscribe((response: any) => {
        this.rows = response;
      });
  }

  public save(entity: any): void {


    this.restApiService.save(entity).subscribe((response: any) => {
      if (response) {
        this.loadList();
      }
    });
  }

  public update(entity: any): void {
    this.restApiService.update(entity)
      .subscribe((response: any) => {
        this.loadList();
      });
  }

  public delete(entity: any): void {
    this.restApiService.delete(entity)
      .subscribe((response: any) => {
        this.loadList();
      });
  }

  /***************************************--************************************************/

  public getParameters(lovAddr: string) {
    console.log("Respuesta LOV loadMultiLov:" + lovAddr);
    return this.restApiService.getParameters(lovAddr);
  }

  public isEditingRow() {
    if (this.selectedRow && this.selectedRow.id) {
      return true
    }
    return false;
  }

  public selectRow(row) {
    this.selectedRow = JSON.parse(JSON.stringify(row));
    this.selectedRow.tipoPension = row.tipoPension.id;
    this.selectedRow.tipoPensionado = row.tipoPensionado.id;
    this.selectedRow.profession = row.profession;
    this.selectedRow.residenceCountry = row.residence.id + "";
    this.selectedRow.familyResidenceCountry = row.familyResidence.id + "";
  }
}
