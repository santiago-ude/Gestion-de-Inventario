import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Product } from '../interface/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

   private apiUrl = "http://localhost:8080/inventoryManagment/api/v1/products";

  constructor(private http : HttpClient) { }


//GET
getProducts() : Observable<Product[]>{
  return this.http.get<Product[]>(this.apiUrl).pipe(catchError(this.handleError));
}

//GETById
getProductById(id : Number) : Observable<Product>{
  return this.http.get<Product>(`${this.apiUrl}/${id}`).pipe(catchError(this.handleError));
}

//POST
postProduct(product : Product) : Observable<Product>{
  return this.http.post<Product>(this.apiUrl, product).pipe(catchError(this.handleError));
}

//PUT
putProduct(product : Product, id : Number) : Observable<Product>{
  return this.http.put<Product>(`${this.apiUrl}/${id}`, product).pipe(catchError(this.handleError));
}

//PATCH
patchProduct(updateData: Partial<Product>, id : Number) : Observable<Product>{
  return this.http.patch<Product>(`${this.apiUrl}/${id}`, updateData).pipe(catchError(this.handleError));
}

//DELETE
deleteProduct(id : Number) : Observable<Product>{
  return this.http.delete<Product>(`${this.apiUrl}/${id}`).pipe(catchError(this.handleError));
}



private handleError(error: HttpErrorResponse): Observable<never> {
  console.error('Error en el servicio de Productos:', error);
  return throwError(() => new Error('Error en la solicitud del servidor'));
}
}
