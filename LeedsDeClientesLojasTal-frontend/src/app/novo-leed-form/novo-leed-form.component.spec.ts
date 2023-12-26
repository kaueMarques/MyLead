import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NovoLeedFormComponent } from './novo-leed-form.component';

describe('NovoLeedFormComponent', () => {
  let component: NovoLeedFormComponent;
  let fixture: ComponentFixture<NovoLeedFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NovoLeedFormComponent]
    });
    fixture = TestBed.createComponent(NovoLeedFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
