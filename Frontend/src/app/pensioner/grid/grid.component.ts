import {Component, OnInit} from '@angular/core';
import {PAsideService} from "../../commons/p-aside/p-aside.service";
import {PensionerBusinessService} from "../business.service";
import {PensionerFormComponent} from "../form/form.component";

@Component({
  selector: 'app-pensioners-grid',
  templateUrl: './grid.component.html',
  styleUrls: ['./grid.component.less']
})
export class PensionersGridComponent implements OnInit {

  public rows: Array<any>;

  public columns: Array<any> = [
    {title: 'Nombre', className: 'text-warning', name: 'nombre'},
    {title: 'Apellido', className: 'text-warning', name: 'apellido'},
    {title: 'Identificación', name: 'legalIdCard'}
  ];

  constructor(private asideService: PAsideService,
              public businessService: PensionerBusinessService) {
  }

  ngOnInit() {
    this.asideService.showAside(PensionerFormComponent);
    this.businessService.loadList();
  }

  public getRowData(row, data) {
    return row [data];
  }

  public editRow(row: any) {
    this.businessService.selectRow(row);
  }

  public deleteRow(row: any) {
    this.businessService.delete(row);
    console.log(row);
  }


}
