import { Component, OnInit } from '@angular/core';
import { EcommerceService } from "../services/ecommerce.service";
import { Product } from "../models/product.model";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-products-details',
  templateUrl: './products-details.component.html',
  styleUrls: ['./products-details.component.scss']
})
export class ProductsDetailsComponent implements OnInit {

  product: Product;

  constructor(private ecommerceService: EcommerceService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getProduct()
  }

  getProduct(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.ecommerceService.getProduct(id)
      .subscribe(product => this.product = product);
  }

}
