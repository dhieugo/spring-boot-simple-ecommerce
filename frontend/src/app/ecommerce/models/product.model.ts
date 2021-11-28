import { Brand } from "./brand.model";
import { Category } from "./category.model";
import { ProductAttributes } from "./product-attributes.model";

export class Product {
  id: number;
  productName: string;
  price: number;
  sku: string;
  brand: Brand;
  category: Category;
  attributes: ProductAttributes[] = [];
}
