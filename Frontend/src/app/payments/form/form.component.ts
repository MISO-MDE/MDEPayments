import {Component, OnInit} from '@angular/core';

import {PaymentsBusinessService} from "../business.service";
@Component({
  selector: 'app-payment-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.less']
})
export class PaymentFormComponent implements OnInit {

  constructor(private businessService: PaymentsBusinessService) {
  }

  ngOnInit() {
  }

  public getRowData(row, data) {
    return row [data];
  }

  getEntity() {
    this.businessService.loadEntity();
  }

  calculatePayment() {
    this.businessService.calculatePayment();
  }
}
