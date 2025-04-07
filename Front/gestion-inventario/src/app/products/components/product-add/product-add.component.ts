import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { ProductService } from '../../service/product.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-product-add',
  imports: [ReactiveFormsModule, CommonModule, HttpClientModule],
  templateUrl: './product-add.component.html',
  styleUrl: './product-add.component.css',
  standalone: true
})
export class ProductAddComponent {


  @Output()
  emitirProduct: EventEmitter<Product> = new EventEmitter();

FB = inject(FormBuilder);



formulario = this.FB.nonNullable.group(
  {
    name: ["", [Validators.required, Validators.minLength(3), Validators.maxLength(100)]],
    description: ["", [Validators.required, Validators.maxLength(500)]],
    price : [0,[Validators.required]],
    stock : [0,[Validators.required]],
    brand : ["", [Validators.required, Validators.minLength(2), Validators.maxLength(100)]],
    imageUrl : ["", [Validators.required]]
  }
)
addProduct = () =>{

  console.log(this.formulario.errors); // Verifica si hay errores generales
  for (const controlName in this.formulario.controls) {
      const control = this.formulario.get(controlName);
      console.log(`${controlName} errors:`, control?.errors); // Muestra errores de cada campo
  }

  if(this.formulario.invalid)return;


  const product = this.formulario.getRawValue();
  this.formulario.reset();

  this.emitirProduct.emit(product);

}


}
