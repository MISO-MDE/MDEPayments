import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import {AngularFire} from 'angularfire2';
import {ToasterService, Toast} from 'angular2-toaster/angular2-toaster';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {Observable} from 'rxjs/Rx';

import {IUser} from '../sharedresources/interfaces'

@Injectable()
export class UserApiService {

  private url: string = 'PilaPayments/api/users';

  constructor(private http: Http,
              public angularFire: AngularFire,
              private toasterService: ToasterService) {
  }

  loginFirebaseAuth(email: string, password: string) {
    console.log("EN loginFirebaseAuth " + email + ' PWD ' + password);
    var creds: any = {email: email, password: password};

    var res: Promise<boolean> = new Promise((resolve, reject) => {
      this.angularFire.auth.login(creds, 4).then(result => {
        console.log("THEN angularFire.auth.login " + JSON.stringify(result));
        resolve(result);
      }).catch((error => {
        var toast = {
          type: 'error',
          title: 'Login error',
          body: error.message,
          showCloseButton: true
        };
        this.toasterService.pop(toast);
        console.log("CATCH ERROR angularFire.auth.login " + JSON.stringify(error));
        //reject(error);
      }));
    });
    return res;
  }

  getUserData(userId: String): Observable<IUser> {
    let urlGet = this.url + "/" + userId;
    console.log("User Data Exec: " + urlGet);
    return this.http.get(urlGet).map(this.extractData);
  }

  saveUser(user: IUser) {
    let urlPost = this.url + "/superentity";
    return this.http.post(urlPost, user)
      .map(this.extractData)
      .catch(this.handleError);

  }

  saveUserFirebase(email: string, password: string) {
    var creds: any = {email: email, password: password};
    return this.angularFire.auth.createUser(creds);
  }

  private extractData(res: Response) {
    let body;
    // check if empty, before call json
    if (res.text()) {
      console.log("RETORNO SERVICIO" + JSON.stringify(res));
      body = res.json();
      console.log("JSON" + JSON.stringify(body));
      console.log("JSON1" + body.roleName);
    }

    return body || {};
  }

  handleError(error: any): any {
    console.error("ERROR REST: " + error);
    return Observable.throw(error || 'Server error');
  }

}
