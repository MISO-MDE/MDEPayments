import {Component, OnInit} from '@angular/core';
import {PAsideService} from "./p-aside.service";


@Component({
  selector: 'app-p-aside',
  templateUrl: './p-aside.component.html',
  styleUrls: ['./p-aside.component.less']
})
export class PAsideComponent implements OnInit {

  constructor(public asideService: PAsideService) {
  }

  ngOnInit() {
  }

}
