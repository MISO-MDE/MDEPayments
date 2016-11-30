import {Component, OnInit} from '@angular/core';
import {PAsideService} from "../commons/p-aside/p-aside.service";

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.less']
})
export class HomepageComponent implements OnInit {

  public menuOptions : Array<any> = [
    {
      name:"Pensionados",
      icon:"glyphicon-user",
      route:"pensioners"
    },
    {
      name:"Novedades",
      icon:"glyphicon-fire",
      route:"news"
    },
    {
      name:"Pagos",
      icon:"glyphicon-usd",
      route:"payments"
    }
  ];
  constructor(private asideService: PAsideService) {

  }

  ngOnInit() {
    this.asideService.setCollapsed(true);
  }

}
