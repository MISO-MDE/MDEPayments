import { Injectable } from '@angular/core';
import { Http, Response} from '@angular/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { Observable } from 'rxjs/Rx';

import { INews } from '../commons/sharedresources/interfaces'

@Injectable()
export class EventApiService {
    private url: string = 'PilaPayments/api/event';

    constructor(private http: Http) {
    }

     getEvents(userId: String ): Observable<INews> {
        var urlGet;
        if (userId === '*') {
            urlGet = this.url;
        }
        else {
            urlGet = this.url + "/" + userId;
        }
        return this.http.get(urlGet).map(this.extractData);
    }

    saveNews(news: INews) {
      console.log("Salvando Novedad:" +  JSON.stringify(news));
      return this.http.post(this.url, news)
            .map(this.extractData)
            .catch(this.handleError);
    }

    private extractData(res: Response) {
        let body;
        // check if empty, before call json
        if (res.text()) {
            body = res.json();
        }
        return body || {};
    }

    handleError(error: any): any {
        console.error("ERROR REST: " + error);
        return Observable.throw(error || 'Server error');
    }
}
