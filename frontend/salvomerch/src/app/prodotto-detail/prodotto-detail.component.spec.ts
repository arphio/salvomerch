import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProdottoDetailComponent } from './prodotto-detail.component';

describe('ProdottoDetailComponent', () => {
  let component: ProdottoDetailComponent;
  let fixture: ComponentFixture<ProdottoDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProdottoDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProdottoDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
