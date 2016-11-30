import {Component, OnInit} from '@angular/core';
import {FireLoginService} from "../commons/fire-login/fire-login.service";

@Component({
  selector: 'app-superentity',
  templateUrl: './superentity.component.html',
  styleUrls: ['./superentity.component.less']
})
export class SuperentityComponent implements OnInit {

  public userData: any;

  constructor(public fireLoginService: FireLoginService) {
  }

  ngOnInit() {
    //this.userData = this.fireLoginService.getUserData() || {};
  }

}
