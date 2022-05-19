import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CommonDto } from '../table/table.component';

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
  
  fetch(){
    return this.http.get<CommonDto>(`${this.baseUrl}`+"/fetch");
  }
}
