import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductEditComponent } from './product-edit/product-edit.component';
import { SignupComponent } from './signup/signup.component';
import { SigninComponent } from './signin/signin.component';
import { OrderListComponent } from './order-list/order-list.component';
import { ProductListComponent } from './product-list/product-list.component';
import { UserListComponent } from './user-list/user-list.component';
import {DashbordComponent} from './dashbord/dashbord.component'
import {AdminService} from './admin.service'


const routes: Routes = [{
  path: 'dashbord',
  component: DashbordComponent,
  // canActivate: [AdminService],
},
{
  path: 'user-list',
  component: UserListComponent,
  // canActivate: [AdminService],
},
{
  path: 'product-list',
  component: ProductListComponent,
  // canActivate: [AdminService],
},
{
  path: 'order-list',
  component: OrderListComponent,
  // canActivate: [AdminService],
},

{
  path: 'product-edit',
  component: ProductEditComponent,
  // canActivate: [AdminService],
},

{ path: 'admin-signin', component: SigninComponent },
{ path: 'admin-signup', component: SignupComponent },];







@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
