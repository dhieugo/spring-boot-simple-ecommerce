import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EcommerceRoutingModule } from "./ecommerce-routing.module";
import { ProductsComponent } from "./products/products.component";
import { ProductsDetailsComponent } from "./products-details/products-details.component";
import { EcommerceService } from "./services/ecommerce.service";
import { HttpClientModule } from "@angular/common/http";
import { EcommerceComponent } from "./ecommerce.component";
import { HeaderComponent } from "../layout/header/header.component";
import { FooterComponent } from "../layout/footer/footer.component";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";

@NgModule({
  declarations: [
    EcommerceComponent,
    ProductsComponent,
    ProductsDetailsComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    CommonModule,
    EcommerceRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [EcommerceService],
})
export class EcommerceModule { }
