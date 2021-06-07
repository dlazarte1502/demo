import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { By } from '@angular/platform-browser';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { NgbModule, NgbTimeStruct } from '@ng-bootstrap/ng-bootstrap';
import { DemoService } from '../demo.service';

import { DemoFormComponent } from './demo-form.component';

describe('DemoFormComponent', () => {
  let component: DemoFormComponent;
  let fixture: ComponentFixture<DemoFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DemoFormComponent ],
      imports: [
        HttpClientModule,
        NgbModule,
        FormsModule,
        ReactiveFormsModule,
        FontAwesomeModule
      ],
      providers: [DemoService, FormBuilder]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DemoFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have title Calculator', () => {
    expect(fixture.nativeElement.querySelector('h5').textContent).toContain('Calculator');
  });

  it('set time time value', () => {
    const data: NgbTimeStruct = {hour: 15, minute: 2, second: 35}
    const control = component.form.get('time');
    control?.setValue(data);
    expect(control?.value).toEqual({hour: 15, minute: 2, second: 35});
  });

  it('set time difference value', () => {
    const data: number = -4;
    const control = component.form.get('timeDifference');
    control?.setValue(data);
    expect(control?.value).toBe(-4);
  });
});
