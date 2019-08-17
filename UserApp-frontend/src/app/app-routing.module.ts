import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { UserComponent } from "./user/user.component";
import { AddUserComponent} from './add-user/add-user.component';

const routes: Routes = [
  { path: 'getUser', component: UserComponent },
  { path: 'addUser', component: AddUserComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }

