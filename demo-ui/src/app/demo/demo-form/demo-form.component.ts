import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { NgbTimeStruct } from '@ng-bootstrap/ng-bootstrap';
import { DemoService } from '../demo.service';
import { TimeItem } from '../models/time-item';
import { TimeItemDto } from '../models/time-item-dto';
import { faCalculator } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-demo-form',
  templateUrl: './demo-form.component.html',
  styleUrls: ['./demo-form.component.sass']
})
export class DemoFormComponent implements OnInit {
  time: NgbTimeStruct = {hour: 0, minute: 0, second: 0};
  seconds = true;
  form: FormGroup;
  model: TimeItemDto;
  faCalculator = faCalculator;

  constructor(private service: DemoService, private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      timeDifference: new FormControl(0, [Validators.required]),
      time: new FormControl(this.time, [Validators.required])
    });
    this.model = {timeZone: "", time: ""}
  }

  ngOnInit(): void {
  }

  calculate() {
    let item: TimeItem = new TimeItem(this.form.get('time')?.value, this.form.get('timeDifference')?.value);
    this.service.calculate(item).subscribe(response => {
      this.model = response;
    });
  }
}
