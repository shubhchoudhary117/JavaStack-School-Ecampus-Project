import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PayFessOnlineService {

  constructor(private http:HttpClient) { }

  paymentUrl:any="http://localhost:7070/student/fees"

  // do payment so call java api
  createPaymentOrder(data:any){
    return this.http.post(`${this.paymentUrl}/create-order`,data)
  }

  // save the student fees details
  doSaveStudentPaidFeesDetails(PaymentDetails:any){
    return this.http.post(`${this.paymentUrl}/save-payment`,PaymentDetails)
  }

  // get the student fees details
  getFeesDetails(token:any){
    return this.http.get(`${this.paymentUrl}/getdetails/${token}`)
  }

  // get the student fees recipts
  getFeesRecipts(token:any){
    return this.http.get(`${this.paymentUrl}/getfees-recipts/${token}`)
  }
}
