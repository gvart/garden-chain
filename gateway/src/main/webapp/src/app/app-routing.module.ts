import { NgModule } from '@angular/core';
import {Routes, RouterModule, ExtraOptions} from '@angular/router';

const routes: Routes = [
  {
    path: 'pages',
    // canActivate: [AuthGuard],
    loadChildren: './pages/pages.module#PagesModule',
  },
  // {
  //   path: 'auth',
  //   loadChildren: './auth/auth.modules#AuthModule',
  // },
  { path: '', redirectTo: 'pages', pathMatch: 'full' },
  { path: '**', redirectTo: 'pages' },
];

const config: ExtraOptions = {
  useHash: true,
};

@NgModule({
  imports: [RouterModule.forRoot(routes, config)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
