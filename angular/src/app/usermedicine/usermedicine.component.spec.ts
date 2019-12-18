import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsermedicineComponent } from './usermedicine.component';

describe('UsermedicineComponent', () => {
  let component: UsermedicineComponent;
  let fixture: ComponentFixture<UsermedicineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsermedicineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsermedicineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
