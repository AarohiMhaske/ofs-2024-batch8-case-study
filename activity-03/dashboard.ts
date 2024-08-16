/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import * as AccUtils from "../accUtils";
import * as ko from "knockout";
import "oj-c/input-text";
import "ojs/ojknockout";
import "oj-c/input-number";
import 'oj-c/input-password';
import "oj-c/input-date-text";
import 'oj-c/form-layout';
import "oj-c/button";
import 'oj-c/message-banner';
import 'oj-c/message-toast';
import "oj-c/progress-bar";

class DashboardViewModel {
  value: ko.Observable<string>;
  firstname: ko.Observable<any>;
  salary: ko.Observable<number> | ko.Observable<any>;
  password: ko.Observable<any>;
  date: ko.Observable<Date> | ko.Observable<any>;
  progressValue: ko.Observable<Number> | ko.Observable<any>;

  constructor() {
    this.value = ko.observable("Green");
    this.firstname = ko.observable(null);
    this.salary = ko.observable(null);
    this.password = ko.observable(null);
    this.date = ko.observable(null);
    this.progressValue = ko.observable(50);
  }
}

export = DashboardViewModel;