import { RouterModule, Routes } from "@angular/router";
import { EcommerceComponent } from "./ecommerce.component";
import { ProductsComponent } from "./products/products.component";
import { ProductsDetailsComponent } from "./products-details/products-details.component";

const ROUTES: Routes = [
  {
    path: '',
    component: EcommerceComponent,
    children: [
      { path: '', component: ProductsComponent},
      {
        path: 'details/:id',
        component: ProductsDetailsComponent
      }
    ]
  }
];

export const EcommerceRoutingModule = RouterModule.forChild(ROUTES);
