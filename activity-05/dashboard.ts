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
class DashboardViewModel {
  value: ko.Observable<string>;
  firstname: ko.Observable<any>;
  salary : ko.Observable<number> | ko.Observable<any>;
  password : ko.Observable<any>;
  date : ko.Observable<Date> | ko.Observable<any>;
  progressValue: ko.Observable<Number> | ko.Observable<any>;
  username: ko.Observable<any>;
  email : ko.Observable<any>;
  address : ko.Observable<any>;
    constructor() {
      this.value = ko.observable("Green");
      this.firstname = ko.observable(null);
      this.salary = ko.observable(null);
      this.password = ko.observable(null);
      this.date = ko.observable(null);
      this.progressValue = ko.observable(50);
      this. username = ko.observable(null);
      this.email = ko.observable(null);
      this.address = ko.observable(null);
    }
    public handleClick = async (event:Event) => {
      let elementName = (event.currentTarget as HTMLElement).tagName;
      // alert("you clicked on a button: " +elementName);
      // alert("Name="+this.firstname()+", Salary="+this.salary());
      console.log("Name="+this.firstname()+", Salary="+this.salary());
      console.log("Element Name = "+elementName)
      let id = parseInt(this.firstname());
      let url = "https://jsonplaceholder.typicode.com/users/"+id;
      let res = await fetch(url);
      let jsonData = await res.json();
      this.firstname(jsonData.name);
      this.username(jsonData.username);
      this.email(jsonData.email);
      this.address(jsonData.address.street),
      console.log(jsonData);
    }
}
export = DashboardViewModel;