import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TelefoneFormComponent } from './telefone-form.component';

describe('TelefoneFormComponent', () => {
  let component: TelefoneFormComponent;
  let fixture: ComponentFixture<TelefoneFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TelefoneFormComponent]
    });
    fixture = TestBed.createComponent(TelefoneFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
