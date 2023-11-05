import { Component, NgZone, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PayFessOnlineService } from 'src/app/services/PaymentsServices/pay-fess-online.service';
import { WindowRefService } from 'src/app/services/PaymentsServices/window-ref.service';
import { TokenService } from 'src/app/services/token.service';
import { HttpClient } from '@angular/common/http';
import { NgxSpinnerService } from 'ngx-spinner';
import Swal from 'sweetalert2';
import { StudentprofileService } from 'src/app/services/EcampusServices/StudentProfileServices/studentprofile.service';
@Component({
  selector: 'app-studentfees',
  templateUrl: './studentfees.component.html',
  styleUrls: ['./studentfees.component.css']
})
export class StudentfeesComponent implements OnInit {

  spinnerType: any;
  spinnerName: any;
  activeLoader:boolean=false;
  constructor
    (
      private studentProfileService: StudentprofileService,
      public feesService: PayFessOnlineService, private ng: NgZone,
      private winRef: WindowRefService, private router: Router,
      private tokenService: TokenService,
      private spinner: NgxSpinnerService
    ) {

   
  }

  ngOnInit() {
    // call the student profile details api
    this.getStudentDetails();
    // get the student fees details
    this.getStudentFeesDetails();

    
    this.spinnerName = "sp1";
    this.spinnerType = "ball-atom";
    this.spinner.show(this.spinnerName);
    

    
  }

  // validation errors variables
  invalidAmountError: Boolean = false;


  // create sum calculation variables
  totalFees: any;
  busFees: any;
  student: any;
  // payment details object
  paymentPayload: any = {
    ammount: "",
    token: localStorage.getItem("token")
  }

  // get the student 
  getStudentDetails() {
    // call the profile service for get user details 
    this.studentProfileService.getStudentProfile(this.tokenService.getToken()).subscribe(
      (response: any) => {
        this.student = response.student;
        this.paymentPayload.ammount = this.student.feesDetails.duefees;
        // check student and set details
      },
      (err: any) => {
        console.log(err)
      }
    )
  }

  // get the student previos and current fees details
  getStudentFeesDetails() {
    this.feesService.getFeesDetails(this.tokenService.getToken()).subscribe(
      (response: any) => {
        console.log(response)
      },
      (error: any) => {
        console.log(error)
      }
    )
  }


  // pay fees payment using rozorpay
  // do submit payment form
  doSubmitPayment() {

    this.activeLoader=true;
    this.spinner.show(this.spinnerName);

    setTimeout(() => {
      this.activeLoader=false;
      this.spinner.hide(this.spinnerName);

      if (this.paymentPayload.ammount <= 0) {
        this.invalidAmountError = true;
      } else {
        this.invalidAmountError = false;
        // call api successfully
        // call the payment service
        this.feesService.createPaymentOrder(this.paymentPayload).subscribe(
          (response: any) => {
            console.log(response)
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

    }, 5000);
    
   
   
  }


  // do payment
  options: any;
  doPayment(order: any) {
    // create options object
    var newThis = this;
    this.options = {
      key: 'rzp_test_VfKCRNfVkjtHFd',
      amount: order.amount,
      currency: "INR",
      name: "Shree reva gurjar ecampus sanawad",
      description: "Pay online Fees",
      image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHXbffIPSvVpJ8Lyu-0MlD3YZCMIYBA5wstAiQlSZN&s",
      order_id: order.id,
      handler: (response: any) => this.doSaveDetails(response),
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
    // const rzp=new Razorpay(this.options);
    rzp.open();
    rzp.on('payment.failed', function (response: any) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Something went wrong!',
        footer: '<a href="">Why do I have this issue?</a>'
      })
    });
    // end of paymet failier 
    // create handle response function


  }
  // end of doPayment function


  doSaveDetails(response: any) {

    // create the successfull payment done student feed details object
    const studentPaymentDetails = {
      token: localStorage.getItem("token"),
      paymentid: response.razorpay_payment_id,
      orderid: response.razorpay_order_id,
      ammount: this.paymentPayload.ammount
    }

    if (response.razorpay_order_id != "" && response.razorpay_payment_id != "" && response.razorpay_signature != "") {


      // after payment successfull
      this.feesService.doSaveStudentPaidFeesDetails(studentPaymentDetails).subscribe(
        (response: any) => {
          console.log(response)
          // if payment done successfully
          if (response.feesPaySuccessfull) {
            this.activeLoader=false
            Swal.fire({
              target: ".fees-success-alert",
              icon: 'success',
              title: 'fess pay is successfully',
              showConfirmButton: false,
              timer: 1500
            })

            window.location.href="http://localhost:4200/student/dashboard/fees";
          }
          // if some thing went wrong
          else if (response.somethingwentwrong) {
            Swal.fire({
              icon: 'error',
              title: 'Oops...',
              text: 'Something went wrong!',
              footer: '<a href="">Why do I have this issue?</a>'
            });
            // call the function 
            this.getStudentDetails();
          }
        },
        (error: any) => {
          console.log(error)
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Something went wrong!',
            footer: '<a href="">Why do I have this issue?</a>'
          });
        }
      )
    }

  }
  // end of doSave details function
};




// console.log(response)
// console.log(response)
// if (response.razorpay_order_id != "" && response.razorpay_payment_id != "" && response.razorpay_signature != "") {
//   Swal.fire({
//     target: ".fees-success-alert",
//     icon: 'success',
//     title: 'fess pay is successfully',
//     showConfirmButton: false,
//     timer: 1500
//   })

//   // // create the successfull payment done student feed details object
//   // const studentPaymentDetails = {
//   //   token: localStorage.getItem("token"),
//   //   paymentid: response.trazorpay_payment_id,
//   //   orderid: response.razorpay_order_id,
//   //   ammount: "60000"
//   // }



// }