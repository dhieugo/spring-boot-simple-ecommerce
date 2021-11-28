import { Component, OnInit } from '@angular/core';
import { Product } from '../models/product.model';
import { EcommerceService } from '../services/ecommerce.service';
import { FormControl, FormGroup } from "@angular/forms";
import { Category } from "../models/category.model";
import { Brand } from "../models/brand.model";
import { ProductFilter } from "../dto/product-filter.dto";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {

  products: Product[] = [];
  categories: Category[] = [];
  brands: Brand[] = [];
  filterForm: FormGroup = new FormGroup({
    category: new FormControl(''),
    brand: new FormControl(''),
    price: new FormControl(''),
    color: new FormControl(''),
  })

  constructor(private ecommerceService: EcommerceService) { }

  ngOnInit(): void {
    this.loadProducts();
    this.loadCategories();
    this.loadBrands();
  }

  loadProducts(filter?: ProductFilter) {
    if (!filter) {
      filter = new ProductFilter();
    }
    this.ecommerceService.getAllProducts(filter).subscribe((res: any) => {
      this.products = res.content;
    });
}

  private loadCategories() {
    this.ecommerceService.getAllCategories().subscribe((res: any) => {
      this.categories = res.content;
    });
  }

  private loadBrands() {
    this.ecommerceService.getAllBrands().subscribe((res: any) => {
      this.brands = res.content;
    });
  }

  onSubmitSearch() {
    console.warn(this.filterForm.value);
    this.loadProducts(this.filterForm.value);
  }
}
