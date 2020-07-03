import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddUpProdottoComponent } from './add-up-prodotto.component';

describe('AddProdottoComponent', () => {
  let component: AddUpProdottoComponent;
  let fixture: ComponentFixture<AddUpProdottoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddUpProdottoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddUpProdottoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
