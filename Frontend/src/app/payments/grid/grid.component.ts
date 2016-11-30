import {Component, OnInit} from '@angular/core';
import {PAsideService} from "../../commons/p-aside/p-aside.service";
import {PaymentFormComponent} from "../form/form.component";
import {PaymentsBusinessService} from "../business.service";

@Component({
  selector: 'app-payments',
  templateUrl: './grid.component.html',
  styleUrls: ['./grid.component.less']
})
export class PaymentsComponent implements OnInit {

  constructor(private asideService: PAsideService,
              private businessService: PaymentsBusinessService) {
  }

  ngOnInit() {
    this.asideService.showAside(PaymentFormComponent);
    this.businessService.loadPayments();
  }

  public editRow(row: any) {
    console.log(row);
  }

  public deleteRow(row: any) {
    console.log(row);
  }

  public getRowData(row, data) {
    return row [data];
  }

}
