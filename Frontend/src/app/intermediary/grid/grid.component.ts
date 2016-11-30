import {Component, OnInit} from '@angular/core';
import {PAsideService} from "../../commons/p-aside/p-aside.service";
import {IntermediaryFormComponent} from "../form/form.component";
import {IntermediaryBusinessService} from "../business.service";
@Component({
  selector: 'app-intermediary',
  templateUrl: './grid.component.html',
  styleUrls: ['./grid.component.less']
})
export class IntermediaryComponent implements OnInit {
  constructor(private asideService: PAsideService,
              public businessService: IntermediaryBusinessService) {
  }

  public editRow(row: any) {
    this.businessService.selectRow(row);
  }

  public deleteRow(row: any) {
    this.businessService.deleteSuperEntity(row.id);
  }

  public getRowData(row, data) {
    let value = row [data];
    if (typeof value === 'object') {
      return value.descripcion;
    }
    return value;
  }

  ngOnInit() {
    this.asideService.showAside(IntermediaryFormComponent);
    this.businessService.loadSuperEntity();
  }
}
