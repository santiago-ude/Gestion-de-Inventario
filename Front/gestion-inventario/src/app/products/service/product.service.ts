import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Product } from '../interface/product';
import { ProductAddComponent } from '../components/product-add/product-add.component';

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
