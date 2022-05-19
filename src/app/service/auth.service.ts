import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  baseUrl : string ="http://localhost:9090";

  constructor(private http: HttpClient) { }

  save(input : any) {
    const headers={
      "Content-type": "application/json"
    }
    return this.http.post(`${this.baseUrl}` + "/save",input,{headers});
  }
  fetch(input : any){
    return this.http.get(`${this.baseUrl}`+"/fetch");
  }
}
