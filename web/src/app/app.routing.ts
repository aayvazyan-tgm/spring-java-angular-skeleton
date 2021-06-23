import {RouterModule, Routes} from "@angular/router";
import {IndexComponent} from "./index/index.component";

const routes: Routes = [
  {path: '', component: IndexComponent},
  //fallback
  {path: '**', redirectTo: ''}
];

export const appRoutingModule = RouterModule.forRoot(routes);
