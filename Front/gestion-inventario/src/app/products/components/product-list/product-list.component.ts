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

  ngOnInit(): void {
    this.traerProducts();
  } 


  showModal = false;

  productToEdit!: Product;

  productList : Product[] = [];

  PS = inject(ProductService);


  traerProducts(){
    return this.PS.getProducts().subscribe({
      next: (list) => this.productList = list
    })
  }

  closeEditModal() {
    this.showModal = false;
  }

  recargarLista() {
    this.traerProducts(); // o como tengas tu lógica de fetch
  }

  openEditModal(product: Product) {
    this.productToEdit = product;
    this.showModal = true;
  }



  
  increaseStock(product : any) {
    
    const updateProduct = { stock: product.stock + 1};

    this.PS.patchProduct(updateProduct, product.id).subscribe({
      next: (updateProd) => {
        product.stock = updateProd.stock; //actualizamos en el front
      },
      error: (err) => console.error("Error al actualizar el stock: " + err)
    });

}

decreaseStock(product :  any){
  
  if(Number(product.stock) != 0){

  const updateProduct = { stock: product.stock - 1};

    this.PS.patchProduct(updateProduct, product.id).subscribe({
      next: (updateProd) => {
        product.stock = updateProd.stock; //actualizamos en el front
      },
      error: (err) => console.error("Error al actualizar el stock: " + err)
    });
  }
}





   //Optimizar el seguimiento de los elementos dentro del ngFor
   trackByIndex(index: number, item: any): number {
    return index;
  }


}
