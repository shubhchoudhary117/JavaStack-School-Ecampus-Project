import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() { }

  
  // get token from localstorage
 public  getToken(){
    let token=localStorage.getItem("token")
    return token;
  }
// delete a authenticaton jwt token during logout a user
public deleteToken(){
  localStorage.removeItem("token")
}

 
}
