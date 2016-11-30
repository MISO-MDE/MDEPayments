import {Injectable} from '@angular/core';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {EventApiService} from "./rest.api.service";
import {News} from "../commons/sharedresources/classes";
import {INews} from "../commons/sharedresources/interfaces";

@Injectable()
export class NewsBusinessService {
  public rows: Array<INews>;

  public columns: Array<any> = [
    {title: 'Tipo', className: 'text-warning', name: 'tipoNovedad'},
    {title: 'Fecha inicial', className: 'text-warning', name: 'fechaInicio'},
    {title: 'Fecha final', className: 'text-warning', name: 'fechaFin'},
    {title: 'Estado', name: 'status'}
  ];
  public selectedRow:any = {};
  public selectedEntity:any={};

  constructor(private eventApiService: EventApiService) {
  }

  public selectRow(row) {
    this.selectedRow = JSON.parse(JSON.stringify(row));
    console.log("SelectedRow:" + JSON.stringify(this.selectedRow))
    this.selectedRow.entityId = row.entityId;
  }


  public loadEvents(cedulaEntity:string): any {
    this.eventApiService.getEvents(cedulaEntity)
      .subscribe((response: any) => {
        this.rows = response;
      });
  }

   public saveNews(news: News): void {
     news.entityId = this.selectedEntity.id;
     news.fechaCreacion = new Date();
     news.cedulaEntity = this.selectedEntity.cedula;
    this.eventApiService.saveNews(news).subscribe((response: any) => {
      if (response) {
        this.loadEvents(this.selectedEntity.cedula);
      } else {
        console.log("**ERORR: No se guardo la Novedad revisar Logs");
      }
    });
  }

}
