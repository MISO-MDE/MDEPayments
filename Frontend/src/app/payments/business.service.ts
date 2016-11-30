import {Injectable} from '@angular/core';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {PaymentApiService} from "./rest.api.service";
import {PensionerApiService} from "../pensioner/rest.api.service";
@Injectable()
export class PaymentsBusinessService {
  public rows: Array<any>;

  public columns: Array<any> = [
    {title: 'Nombre', name: 'nombre'},
    {title: 'Apellido', name: 'apellido'},
    {title: 'Monto', name: 'amount'},
    {title: 'Fecha', name: 'paymentDate'},
    {title: 'Estado', name: 'status'}
  ];

  public selectedRow = {};
  public selectedEntity: any = {};
  public showValidations = false;


  constructor(private paymentApiService: PaymentApiService,
              private pensionerService: PensionerApiService) {
  }

  calculatePayment() {
    this.paymentApiService.getPaymentCalculation(this.selectedEntity.cedula)
      .subscribe((paymentObj: any) => {
        if (paymentObj.errorCondition != null) {
          this.rows = paymentObj.errorCondition;
          this.showValidations = true;
        }
        else {
          this.selectedRow = paymentObj
        }
      });
  }

  loadEntity() {
    this.pensionerService.loadById(this.selectedEntity.cedula)
      .subscribe((entityObj: any) => {
        this.selectedEntity = entityObj;
      });
  }

  public loadPayments(): any {
    this.paymentApiService.getPayments('*')
      .subscribe((response: any) => {
        this.rows = response.results;
      });
  }

}
