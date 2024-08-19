/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */

import * as ko from "knockout";
import "oj-c/input-text";
import "ojs/ojknockout";
import * as AccUtils from "../accUtils";
import "oj-c/input-number";
import 'oj-c/input-password';
import "oj-c/input-date-text";
import 'oj-c/form-layout';
import 'oj-c/radioset';
import "oj-c/button";
import 'oj-c/message-banner';
import "oj-c/progress-bar";
import "ojs/ojtable";
import ArrayDataProvider = require("ojs/ojarraydataprovider");

class IncidentsViewModel {
  password : ko.Observable<any>;
  loginattempts : ko.Observable<number> | ko.Observable<any>;
  loginstatus: ko.Observable<any>;
  loginid: ko.Observable<any>;

  constructor() {
    this.password=ko.observable(null);
    this.loginattempts=ko.observable(0);
    this.loginstatus=ko.observable('ACTIVE');
    this.loginid=ko.observable(null);
  }

  public handleClick = async (event: Event) => {
    // alert('Button was clicked!');
    // this.clickedButton('Clicked');
    // let id = parseInt(this.firstName());
    let url = 'http://localhost:8080/login/create';
    const row = {
      "password": this.password(),
      "loginAttempts":this.loginattempts(),
      "loginStatus":this.loginstatus()
    };
    console.log(row);
    const request = new Request(url, {
      headers: new Headers({
        "Content-Type": "application/json",
      }),
      body: JSON.stringify(row),
      method: "POST",
    });
    const response = await fetch(request);
    console.log(await response.json());
  }

  /**
   * Optional ViewModel method invoked after the View is inserted into the
   * document DOM.  The application can put logic that requires the DOM being
   * attached here.
   * This method might be called multiple times - after the View is created
   * and inserted into the DOM and after the View is reconnected
   * after being disconnected.
   */
  connected(): void {
    AccUtils.announce("Incidents page loaded.");
    document.title = "Incidents";
    // implement further logic if needed
  }

  /**
   * Optional ViewModel method invoked after the View is disconnected from the DOM.
   */
  disconnected(): void {
    // implement if needed
  }

  /**
   * Optional ViewModel method invoked after transition to the new View is complete.
   * That includes any possible animation between the old and the new View.
   */
  transitionCompleted(): void {
    // implement if needed
  }
}

export = IncidentsViewModel;
