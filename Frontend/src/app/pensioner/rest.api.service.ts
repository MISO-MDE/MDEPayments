import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {Observable} from 'rxjs/Rx';

@Injectable()
export class PensionerApiService {
  private url: string = 'PilaPayments/api';

  constructor(private http: Http) {
  }

  public loadList(userId: String): Observable<any> {
    var urlGet;
    if (userId === '*') {
      urlGet = this.url + '/entities';
    }
    else {
      urlGet = this.url + '/entities' + "?" + userId;
    }
    return this.http.get(urlGet).map(this.extractData);
  }

  save(data: any) {
    console.log("Save:" + JSON.stringify(data));
    return this.http.post(this.url + '/entities', data)
      .map(this.extractData)
      .catch(this.handleError);
  }

  update(data: any) {
    console.log("Update:" + JSON.stringify(data));
    return this.http.put(this.url + '/entities', data)
      .map(this.extractData)
      .catch(this.handleError);
  }

  delete(data: any) {
    console.log("Delete:" + JSON.stringify(data));
    return this.http.delete(this.url + '/entities' + "/" + data.id, data)
      .map(this.extractData)
      .catch(this.handleError);
  }

  loadById(legalIdCard: String): Observable<any> {
    var urlGet;
    urlGet = this.url + '/entities' + "/entity?id=" + legalIdCard;
    console.log("Entidad URL:" + urlGet);
    return this.http.get(urlGet).map(this.extractData);
  }

  private extractData(res: Response) {
    let body;
    if (res.text()) {
      body = res.json();
    }
    return body || {};
  }

  handleError(error: any): any {
    console.error("ERROR REST: " + error);
    return Observable.throw(error || 'Server error');
  }

  getParameters(resourceUrl: string) {
    let url = this.url + resourceUrl;
    return this.http.get(url).map(this.extractData);
  }

}
