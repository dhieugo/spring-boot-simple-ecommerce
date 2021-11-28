import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { Product } from "../models/product.model";
import { Category } from "../models/category.model";
import { ProductFilter } from "../dto/product-filter.dto";

@Injectable()
export class EcommerceService {

  private productsUrl = "/api/products";
  private categoriesUrl = "/api/categories";
  private brandsUrl = "/api/brands";

  constructor(private http: HttpClient) {

  }

  getAllProducts(filter?: ProductFilter) {
    return this.http.get(`${this.productsUrl}?categories=${filter?.category}&brands=${filter?.brand}&colors=${filter?.color}&price=${filter?.price}`);
  }

  getProduct(id: number): Observable<Product> {
    return this.http.get<Product>(`${this.productsUrl}/${id}`);
  }

  getAllCategories() {
    return this.http.get<Category>(`${this.categoriesUrl}`);
  }

  getAllBrands() {
    return this.http.get<Category>(`${this.brandsUrl}`);
  }
}
