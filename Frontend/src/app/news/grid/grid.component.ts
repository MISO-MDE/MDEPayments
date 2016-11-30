import {Component, OnInit} from '@angular/core';
import {PAsideService} from "../../commons/p-aside/p-aside.service";
import {NewFormComponent} from "../form/form.component";
import {NewsBusinessService} from "../business.service";

@Component({
  selector: 'app-news',
  templateUrl: './grid.component.html',
  styleUrls: ['./grid.component.less']
})
export class NewsComponent implements OnInit {


  constructor(private asideService: PAsideService,
              public businessService: NewsBusinessService) {
  }

  ngOnInit() {
    this.asideService.showAside(NewFormComponent);
    this.businessService.loadEvents('*');
  }

  public editRow(row: any) {
     this.businessService.selectRow(row);
  }

  public deleteRow(row: any) {
    console.log(row);
  }

  public getRowData(row, data) {
    let value = row [data];
    if (typeof value === 'object') {
      return value.name;
    }
    return value;
  }
}
