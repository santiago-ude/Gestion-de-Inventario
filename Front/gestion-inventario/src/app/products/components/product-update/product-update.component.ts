import { Component, EventEmitter, inject, Input, Output } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { ProductService } from '../../service/product.service';
import { Product } from '../../interface/product';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-product-update',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './product-update.component.html',
  styleUrl: './product-update.component.css'
})
export class ProductUpdateComponent {


FB = inject(FormBuilder);
PS = inject(ProductService);

  @Input() productToEdit!: Product;
  @Output() closed = new EventEmitter<void>();
  @Output() updated = new EventEmitter<void>();

  formulario = this.FB.nonNullable.group({
    name: ['', Validators.required],
    description: ['', Validators.required],
    price: [0, Validators.required],
    stock: [0, Validators.required],
    brand: ['', Validators.required],
    imageUrl: ['', Validators.required],
  });

  ngOnInit() {
    if (this.productToEdit) {
      this.formulario.setValue({
        name: this.productToEdit.name,
        description: this.productToEdit.description,
        price: this.productToEdit.price,
        stock: this.productToEdit.stock,
        brand: this.productToEdit.brand,
        imageUrl: this.productToEdit.imageUrl,
      });
    }
  }

  updateProduct() {
    if (this.formulario.invalid) return;

    const updatedProduct = this.formulario.getRawValue();
    this.PS.putProduct(updatedProduct, this.productToEdit.id!).subscribe(() => {
      this.updated.emit(); // le avisa al padre que se actualizó
      this.closed.emit();  // cierra el modal
    });
  }

  close() {
    this.closed.emit();
  }


}
