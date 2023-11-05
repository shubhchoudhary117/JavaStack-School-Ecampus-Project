import { TokenType } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudentprofileService } from 'src/app/services/EcampusServices/StudentProfileServices/studentprofile.service';
import { PayFessOnlineService } from 'src/app/services/PaymentsServices/pay-fess-online.service';
import { WindowRefService } from 'src/app/services/PaymentsServices/window-ref.service';
import { TokenService } from 'src/app/services/token.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-pay-fees',
  templateUrl: './pay-fees.component.html',
  styleUrls: ['./pay-fees.component.css']
})
export class PayFeesComponent implements OnInit {

  constructor(private feesService: PayFessOnlineService, 
    private winRef: WindowRefService, private router: Router,
   ) { }

  ngOnInit() {
  
  }

  // payment form variables
  paymentPayload: any = {
    name: "",
    email: "",
    enrollment: "",
    ammount: ""
  }

  student:any;

  // validation variables
  allFieldsEmpty: Boolean = false;
  nameFieldEmpty: Boolean = false;
  emailFieldEmpty: Boolean = false;
  enrollmentFieldEmpty: Boolean = false;
  ammountFieldEmpty: Boolean = false;
  invalidAmountError: Boolean = false;

 
  // do submit payment form
  doSubmitPayment() {
    if (this.paymentPayload.name != "" && this.paymentPayload.email != "" && this.paymentPayload.enrollment != "" && this.paymentPayload.ammount != "") {
      // set false all validatin
      this.allFieldsEmpty = false;
      this.nameFieldEmpty = false;
      this.emailFieldEmpty = false;
      this.enrollmentFieldEmpty = false;
      this.ammountFieldEmpty = false;

      if (this.paymentPayload.ammount <= 0) {
        this.invalidAmountError = true;
      } else {
        this.invalidAmountError = false;
        // call api successfully
        // call the payment service
        this.feesService.createPaymentOrder(this.paymentPayload).subscribe(
          (response: any) => {
            console.log(response)
            this.student=response.Student;
            // declare the order object
            var Order = JSON.parse(response.order)
            console.log(Order)
            // check internate connectin and order is create status
            if (!response.internateConnection) {
              if (Order.status == 'created') {
                this.doPayment(Order);
              } else {
                Swal.fire({
                  icon: 'error',
                  title: 'Oops...',
                  text: 'Something went wrong!',
                  footer: '<a href="">Why do I have this issue?</a>'
                })
              }
            } else {
              Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'Something went wrong!',
                footer: '<a href="">Why do I have this issue?</a>'
              })
            }
          },
          (err: any) => {
            console.log(err)
          }
        )
      }
    }
    else {
      if (this.paymentPayload.name == "" && this.paymentPayload.email == "" && this.paymentPayload.enrollment == "" && this.paymentPayload.ammount == "") {
        this.allFieldsEmpty = true;
      } else {
        this.allFieldsEmpty = false
        if (this.paymentPayload.name == "") { this.nameFieldEmpty = true } else { this.nameFieldEmpty = false }
        if (this.paymentPayload.email == "") { this.emailFieldEmpty = true } else { this.emailFieldEmpty = false }
        if (this.paymentPayload.enrollment == "") { this.enrollmentFieldEmpty = true } else { this.enrollmentFieldEmpty = false }
        if (this.paymentPayload.ammount == "") { this.ammountFieldEmpty = true } else { this.ammountFieldEmpty = false }
      }
    }
  }
  // do payment
  options: any;
  doPayment(order: any) {
    // create options object
    var newThis = this;
    this.options = {
      key: 'rzp_test_LO8OOAc3tfdq9p',
      amount: order.amount,
      currency: "INR",
      name: "Shree reva gurjar ecampus sanawad",
      description: "Pay online Fees",
      image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHXbffIPSvVpJ8Lyu-0MlD3YZCMIYBA5wstAiQlSZN&s",
      order_id: order.id,
      handler: function (response: any) {
        console.log(response)
        if (response.razorpay_order_id != "" && response.razorpay_payment_id != "" && response.razorpay_signature != "") {
          Swal.fire({
            target: ".fees-success-alert",
            icon: 'success',
            title: 'fess pay is successfully',
            showConfirmButton: false,
            timer: 1500
          })
          // after successfull payment
          newThis.afterPaymentSuccessfull();

        }
        // clear fom and navigate

      },
      "prefill": {
        name: "shubham choudahry", //your customer's name
        email: "shubh@gmail.com",
        contact: ""
      },
      notes: {
        address: "Razorpay Corporate Office"
      },
      theme: {
        color: "#6739b7"
      }

    }
    // generate form
    const rzp = new this.winRef.nativeWindow.Razorpay(this.options);
    rzp.open();
    rzp.on('payment.failed', function (response: any) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Something went wrong!',
        footer: '<a href="">Why do I have this issue?</a>'
      })
    });

  }
  // end of doPayment function

  afterPaymentSuccessfull() {
    // window.location.href="http://localhost:4200/student/dashboard/payfees";
    //  clear form and navigate
    // this.router.navigateByUrl("student/dashboard/payfees")
    // navigate fees component
  }

}
