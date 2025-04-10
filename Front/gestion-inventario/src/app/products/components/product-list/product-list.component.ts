import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { Product } from '../../interface/product';
import { ProductService } from '../../service/product.service';
import { RouterLink } from '@angular/router';
import { ProductUpdateComponent } from '../product-update/product-update.component';

@Component({
  selector: 'app-product-list',
  imports: [CommonModule, ProductUpdateComponent],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent {

}
