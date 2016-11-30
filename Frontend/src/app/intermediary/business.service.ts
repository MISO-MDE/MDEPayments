import {Injectable} from '@angular/core';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {IntermediaryApiService} from "./rest.api.service";
import {SuperEntity, User} from "../commons/sharedresources/classes";
import {UserApiService} from "../commons/fire-login/user.api.service";
@Injectable()
export class IntermediaryBusinessService {
  public rows: Array<any>;
  public columns: Array<any> = [
    {title: 'Nombre empresa', className: 'col-md-1', name: 'name'},
    {title: 'NIT', className: 'col-md-1', name: 'nit'},
    {title: 'Actividad económica', className: 'col-md-4', name: 'actividad'}
  ];
  public selectedRow:any = {};
  public econActivities = [];

  constructor(private restApiService: IntermediaryApiService,
              private userApiService: UserApiService) {
  }

  public isEditingRow() {
    if (this.selectedRow && this.selectedRow.id) {
      return true
    }
    return false;
  }

  public selectRow(row) {
    this.selectedRow = row;
    this.selectedRow.actividadeconomica = parseInt(row.actividad.id);
    this.selectedRow.tipoPagador = parseInt(row.tipoPagador.id);
  }

  public addNewRow(row) {
    this.rows.push(row);
  }

  public resetSelectedRow() {
    this.selectedRow = {};
  }

  public loadSuperEntity(): any {
    this.restApiService.getSuperEntityData('*')
      .subscribe((response: any) => {
        this.rows = response;
      });
  }

  //Crea la superentidad y crea el administrador quien podra entrar a como admin de superentidad
  public saveSuperEntity(superEntity: SuperEntity, user: User): void {
    console.log("**Intermediary:Save Superentity " + superEntity.name + ' NIT ' + superEntity.nit);
    this.restApiService.saveSuperEntity(superEntity).subscribe((response: any) => {
      if (response) {
        this.loadSuperEntity();
        this.resetSelectedRow();
        //Salva ahora el administrador luego de que la superentidad quedo guardada
        console.log("**SUCCESS: Se guardo la superentidad" + JSON.stringify(response));
        //Crea objeto tipo usuario para salvar
        let userAdmin = new User(null, response.id, null, user.name, user.email, user.password, 'SuperEntity');
        //Crea el usuario en FireBase email y login
        this.userApiService.saveUserFirebase(userAdmin.email, userAdmin.password).then((result: any) => {
          userAdmin.userId = result.uid;
          console.log("Creando Usuario en Base de Datos" + JSON.stringify(userAdmin));
          //Luego de que se creo en Firebase se crea en la base de datos
          this.userApiService.saveUser(userAdmin).subscribe((status: boolean) => {
            if (status) {
              console.log("**SUCCESS: Se guardo Administrador" + JSON.stringify(status));
            } else {
              console.log("**ERROR: No se guardo el Administradior revisar Logs");
            }
          });
        });
      } else {
        console.log("**ERORR: No se guardo la superentidad revisar Logs");
      }
    });
  }

  public updateSuperEntity(superEntity: SuperEntity): void {
    this.restApiService.updateSuperEntity(superEntity)
      .subscribe((response: any) => {
        this.loadSuperEntity();
      });
  }

  public deleteSuperEntity(id: string) {
    this.restApiService.deleteSuperEntity(id)
      .subscribe((response: any) => {
        var index = this.rows.indexOf(this.selectedRow, 0);
        if (index > -1) {
          this.rows.splice(index, 1);
          this.selectedRow = {};
        }
      });
  }


  public loadEconnActivities() {
    this.restApiService.getEconnActivities()
      .subscribe((response: any) => {
        this.econActivities = response;
      });
  }

  public getParameters(url:string) {
    return this.restApiService.getParameters(url);
  }
}
