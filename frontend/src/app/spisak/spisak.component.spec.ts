import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpisakComponent } from './spisak.component';

describe('SpisakComponent', () => {
  let component: SpisakComponent;
  let fixture: ComponentFixture<SpisakComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SpisakComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SpisakComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
