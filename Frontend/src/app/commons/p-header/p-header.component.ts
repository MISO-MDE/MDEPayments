import { Component, OnInit } from '@angular/core';
import {FireLoginService} from "../../commons/fire-login/fire-login.service";

@Component({
  selector: 'app-p-header',
  templateUrl: './p-header.component.html',
  styleUrls: ['./p-header.component.less']
})
export class PHeaderComponent implements OnInit {

  constructor(public fireLoginService :FireLoginService) { }

  ngOnInit() {
  }

}
