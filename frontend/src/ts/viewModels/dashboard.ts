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

class DashboardViewModel {
  firstname: ko.Observable<any>;
  lastname: ko.Observable<any>;
  gender: ko.Observable<any>;
  email: ko.Observable<any>;
  mobile: ko.Observable<any>;
  loginid: ko.Observable<any>;
  customerstatus: ko.Observable<any>;
  customerid: ko.Observable<any>;

  constructor() {
    this.firstname = ko.observable(null);
    this.lastname = ko.observable(null);
    this.gender = ko.observable(null);
    this.email = ko.observable(null);
    this.mobile = ko.observable(null);
    this.loginid = ko.observable(null);
    this.customerstatus = ko.observable('NEW');
    this.customerid = ko.observable(null);
  }

  public handleClick = async (event: Event) => {
    // alert('Button was clicked!');
    // this.clickedButton('Clicked');
    // let id = parseInt(this.firstName());
    let url = 'http://localhost:8080/registration/newcustomer';
    const row = {
      "firstName": this.firstname(),
      "lastName": this.lastname(),
      "gneder": this.gender(),
      "email": this.email(),
      "mobile": this.mobile(),
      "customerStatus": this.customerstatus(),
      login:{
        "loginId":this.loginid()
      }
  }
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

  public getClick = async (event: Event) => {
    // alert('Button was clicked!');
    // this.clickedButton('Clicked');
    // let id = parseInt(this.firstName());
    let url = 'http://localhost:8080/registration/getcustomer/'+this.customerid();
    const request = new Request(url, {
      headers: new Headers({
        "Content-Type": "application/json",
      }),
      method: "GET",
    });
    const response = await fetch(request);
    console.log(await response.json());
  }

  public deleteClick = async (event: Event) => {
    // alert('Button was clicked!');
    // this.clickedButton('Clicked');
    // let id = parseInt(this.firstName());
    let url = 'http://localhost:8080/registration/deletecustomer/'+this.customerid();
    const request = new Request(url, {
      headers: new Headers({
        "Content-Type": "application/json",
      }),
      method: "DELETE",
    });
    const response = await fetch(request);
    console.log(await response.json());
  }

  public getAllClick = async (event: Event) => {
    // alert('Button was clicked!');
    // this.clickedButton('Clicked');
    // let id = parseInt(this.firstName());
    let url = 'http://localhost:8080/registration/getallcustomers';
    const request = new Request(url, {
      headers: new Headers({
        "Content-Type": "application/json",
      }),
      method: "GET",
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
    AccUtils.announce("Dashboard page loaded.");
    document.title = "Dashboard";
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

export = DashboardViewModel;
