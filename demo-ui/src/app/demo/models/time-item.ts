import { NgbTimeStruct } from "@ng-bootstrap/ng-bootstrap";

export class TimeItem {
  hour: NgbTimeStruct;
  timeDifference: number;

  constructor(hour: NgbTimeStruct, timeDifference: number) {
    this.hour = hour;
    this.timeDifference = timeDifference;
  }

  getHour() {
    return this.hour;
  }
}
