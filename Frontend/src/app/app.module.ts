import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {RouterModule}   from '@angular/router';
import {UserApiService} from './commons/fire-login/user.api.service';
import {ModalModule} from 'angular2-modal';
import {BootstrapModalModule} from 'angular2-modal/plugins/bootstrap';
import {AngularFireModule, AuthMethods, AuthProviders} from 'angularfire2';
import {AppComponent} from './app.component';
import {FireLoginComponent} from './commons/fire-login/fire-login.component';
import {HomepageComponent} from './homepage/homepage.component';
import {PAsideComponent} from './commons/p-aside/p-aside.component';
import {PHeaderComponent} from './commons/p-header/p-header.component';
import {PAsideService} from "./commons/p-aside/p-aside.service";
import {PDynamicComponent} from './commons/p-dynamic/p-dynamic.component';
import {Ripple} from "./commons/directives/ripple/ripple";
import {FireLoginService} from "./commons/fire-login/fire-login.service";
import {ToasterModule} from 'angular2-toaster/angular2-toaster';

/***
 * Intermediary
 ***/
import {IntermediaryBusinessService} from "./intermediary/business.service";
import {IntermediaryFormComponent} from './intermediary/form/form.component';
import {IntermediaryComponent} from './intermediary/grid/grid.component';
import {IntermediaryApiService} from './intermediary/rest.api.service';

/***
 * Pensioner
 ***/
import {PensionersGridComponent} from './pensioner/grid/grid.component';
import {PensionerFormComponent} from './pensioner/form/form.component';
import {PensionerApiService} from "./pensioner/rest.api.service";
import {PensionerBusinessService} from "./pensioner/business.service";

/***
 * News
 ***/
import {NewsComponent} from './news/grid/grid.component';
import {NewFormComponent} from './news/form/form.component';
import {EventApiService} from "./news/rest.api.service";
import {NewsBusinessService} from "./news/business.service";
/***
 * Payments
 ***/
import {PaymentsComponent} from './payments/grid/grid.component';
import {PaymentFormComponent} from './payments/form/form.component';
import {PaymentApiService} from "./payments/rest.api.service";
import {PaymentsBusinessService} from "./payments/business.service";
import { SuperentityComponent } from './superentity/superentity.component';


export const firebaseConfig = {
  apiKey: "AIzaSyBum3m_3TdfiQnWHchNdd2mrWK4ql2A7lc",
  authDomain: "angularcli-firebase.firebaseapp.com",
  databaseURL: "https://angularcli-firebase.firebaseio.com",
  storageBucket: "",
  messagingSenderId: "611830520627"
};

const myFirebaseAuthConfig = {
  provider: AuthProviders.Password,
  method: AuthMethods.Password
};


@NgModule({
  declarations: [
    AppComponent,
    FireLoginComponent,
    HomepageComponent,
    IntermediaryComponent,
    PAsideComponent,
    PHeaderComponent,
    PDynamicComponent,
    IntermediaryFormComponent,
    PaymentFormComponent,
    PaymentsComponent,
    NewsComponent,
    NewFormComponent,
    PensionersGridComponent,
    PensionerFormComponent,
    Ripple,
    SuperentityComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ToasterModule,
    RouterModule.forRoot([
      {
        path: '',
        redirectTo: '/login',
        pathMatch: 'full'
      },
      {
        path: 'login',
        component: FireLoginComponent
      },
      {
        path: 'homepage',
        component: HomepageComponent
      },
      {
        path: 'intermediary/homepage',
        component: IntermediaryComponent
      },
      {
        path: 'payments',
        component: PaymentsComponent
      },
      {
        path: 'news',
        component: NewsComponent
      },
      {
        path: 'pensioners',
        component: PensionersGridComponent
      }

    ]),
    HttpModule,
    ModalModule.forRoot(),
    BootstrapModalModule,
    AngularFireModule.initializeApp(firebaseConfig, myFirebaseAuthConfig)
  ],
  providers: [
    //Providers
    FireLoginService,
    PAsideService,
    IntermediaryBusinessService,
    NewsBusinessService,
    PaymentsBusinessService,
    PensionerBusinessService,
    //REST API services
    IntermediaryApiService,
    PensionerApiService,
    EventApiService,
    PaymentApiService,
    UserApiService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
