import { Routes } from '@angular/router';
import { PocetnaComponent } from './pocetna/pocetna.component';
import { AdminComponent } from './admin/admin.component';
import { IgracComponent } from './igrac/igrac.component';
import { SpisakComponent } from './spisak/spisak.component';

export const routes: Routes = [
  {path:'', component:PocetnaComponent},
  {path:'admin', component:AdminComponent},
  {path:'igrac', component:IgracComponent},
  {path:'spisak', component:SpisakComponent}
];
