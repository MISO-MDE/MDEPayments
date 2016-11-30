import {Component, OnInit, ViewContainerRef, ViewEncapsulation} from '@angular/core';

import {Overlay} from 'angular2-modal';
import {Modal} from 'angular2-modal/plugins/bootstrap';
import {Router} from '@angular/router';
import {UserApiService} from './user.api.service';
import {IUser} from '../sharedresources/interfaces'
import {PAsideService} from "../p-aside/p-aside.service";
import {FireLoginService} from "./fire-login.service";

@Component({
  selector: 'app-fire-login',
  templateUrl: './fire-login.component.html',
  styleUrls: ['./fire-login.component.css']
})
export class FireLoginComponent implements OnInit {

  public login: string;
  public password: string;

  constructor(private userApiService: UserApiService,
              overlay: Overlay,
              vcRef: ViewContainerRef,
              public modal: Modal,
              private router: Router, // Variable para que angular sepa donde navegar
              private asideService: PAsideService,
              private fireLoginService :FireLoginService) {
    overlay.defaultViewContainer = vcRef;
  }

  ngOnInit() {
    this.asideService.setCollapsed(true);
  }

  /* Login de usuario: valida el role que tenga el usuario SuperEntidad, o Intermediario y lo lleva a la pagina
   adecuada
   */
  logInUser(): void {
    var res: any;
    console.log("**Login User " + this.login + ' PWD ' + this.password);

    this.userApiService.loginFirebaseAuth(this.login, this.password).then((res: any) => {
      var link: any;
      if (res.uid) {
        this.userApiService.getUserData(res.uid).subscribe((user: IUser) => {
          //guarda la data en un singleton
          this.fireLoginService.setUserData(user);
          localStorage.setItem("userData", JSON.stringify(user));
          console.log("Navega a homepage " + user.roleName);
          if (user.roleName === 'SuperEntity') {
            link = ['/homepage']; // landingpage de la super entidad
          }
          else {
            link = ['/intermediary/homepage']; // landingpage del intermediario
          }
          this.router.navigate(link); // Permite navegar a los detalles con la variable link
        });
      }
    }, (error: any) => {
      console.log("Error Login ");
    });
  }
}
