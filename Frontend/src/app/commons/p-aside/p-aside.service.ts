import {Injectable} from '@angular/core';

@Injectable()
export class PAsideService {
  private collapsed: boolean = true;
  public componentData = null;

  constructor() {
  }

  public setCollapsed(newValue) {
    this.collapsed = newValue;
  }

  public isCollapsed() {
    return this.collapsed;
  }

  public setContent(component: any) {
    this.componentData = {
      component: component,
      inputs: {
        showNum: 9
      }
    };
  }

  public showAside(component: any) {
    this.setContent(component);
    this.setCollapsed(false);
  }

}
