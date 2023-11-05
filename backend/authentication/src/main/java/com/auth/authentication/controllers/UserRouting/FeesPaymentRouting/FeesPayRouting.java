package com.auth.authentication.controllers.UserRouting.FeesPaymentRouting;

import java.rmi.ServerError;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Date;
import javax.swing.text.DateFormatter;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.authentication.EcampusServices.StudentProfileServices.StudentProfileService;
import com.auth.authentication.EcampusServices.StudentProfileServices.StudentProfileServiceImpl;
import com.auth.authentication.Entities.AdminModel.StudentModel.StudentsSchema;
import com.auth.authentication.Entities.FeesModels.GeneratedFeesOrders;
import com.auth.authentication.Entities.FeesModels.StudentFeesDetailsSchema.StudentFeesDetails;
import com.auth.authentication.Entities.FeesModels.StudentsFeesModels.SixClassStudentsFeesModel;
import com.auth.authentication.Entities.StudentModel.EcampusLoginSchema;
import com.auth.authentication.Entities.StudentsProfileModels.StudentEcampusProfileSchema;
import com.auth.authentication.Headers.FessPayHeaders.PaymentGetway.*;
import com.auth.authentication.Headers.FessPayHeaders.StudentsFeesPaidHeaders.PaidFeesDetailsHeader;
import com.auth.authentication.Jwt.JwtUtil;
import com.auth.authentication.Repositery.AuthRepository;
import com.auth.authentication.Repositery.AdminRepository.StudentActionsRepositories.AddNewStudentRepositories.AddStudentRepo;
import com.auth.authentication.Repositery.AdminRepository.StudentsFeesRepositories.GeneratedFeesOrderRepository;
import com.auth.authentication.Repositery.AdminRepository.StudentsFeesRepositories.StudentFeesDetailsRepo;
import com.auth.authentication.Repositery.AdminRepository.StudentsFeesRepositories.StudentPaidFeesDetailsRepository;
import com.auth.authentication.Repositery.StudentEcampusProfileRepositories.StudentEcampusProfileRepo;
import com.auth.authentication.Response.FeesPayResponses.FeesReciptsAPIResponse;
import com.auth.authentication.Response.FeesPayResponses.GetFeesDetailsResponse;
import com.auth.authentication.Response.FeesPayResponses.PaidFeesResponse;
import com.auth.authentication.Response.FeesPayResponses.PaymentOrderResponse;
import com.auth.authentication.UserServices.TokenDetailsService.GetTokenDetailsFromToken;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import okhttp3.Response;

import com.razorpay.Order;

@RestController
@CrossOrigin("*")
@RequestMapping("/student/fees")
public class FeesPayRouting {

    @Autowired
    StudentFeesDetailsRepo studentFeesDetailsRepo;

    @Autowired
    GetFeesDetailsResponse feesDetailsResponse;

    @Autowired
    StudentProfileServiceImpl profileServiceImpl;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    PaidFeesResponse paidFeesResponse;

    @Autowired
    FeesReciptsAPIResponse feesReciptsAPIResponse;

    @Autowired
    AuthRepository authRepository;

    @Autowired
    StudentPaidFeesDetailsRepository paidFeesRepository;

    @Autowired
    PaymentOrderResponse paymentOrderResponse;

    @Autowired
    GeneratedFeesOrderRepository FeesOrderRepository;

    @Autowired
    StudentEcampusProfileRepo studentEcampusProfileRepo;

    @Autowired
    AddStudentRepo addedStudentRepo;

    @Autowired
    GetTokenDetailsFromToken getTokenDetailsFromToken;

    @PostMapping("/create-order")
    public ResponseEntity<?> createOrder(@RequestBody PaymentDetails paymentDetail) throws RazorpayException {
        // // declare the variables
        String token = paymentDetail.getToken();

        StudentEcampusProfileSchema student = null;
        if (token != null) {
            try {
                // update response object
                this.paymentOrderResponse.setTokenIsInvalid(false);
                // extract username from token
                // get username from stored token
                var username = this.jwtUtil.extractUsername(token);
                student = this.profileServiceImpl.getStudent(username);
            } catch (Exception e) {

                this.paymentOrderResponse.setTokenIsInvalid(true);
                this.paymentOrderResponse.setSomethingwentwrong(true);
                e.printStackTrace();
            }
        } else {
            this.paymentOrderResponse.setTokenIsInvalid(true);
        }

        // create Rozrpay order id
        RazorpayClient client = new RazorpayClient("rzp_test_VfKCRNfVkjtHFd",
                "oeiuHaCr4kRHQYVr6kayuDct");
        // create json object
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("amount", Integer.parseInt(paymentDetail.getAmmount()) * 100);
        jsonObject.put("currency", "INR");
        jsonObject.put("receipt", "txn_2533711");
        try {

            // create order object
            Order order = client.Orders.create(jsonObject);
            GeneratedFeesOrders studentFeesOrder = new GeneratedFeesOrders();
            studentFeesOrder.setStudentname(student.getStudentname());
            studentFeesOrder.setEnrollment(student.getEnrollment());
            studentFeesOrder.setEmail(student.getEmail());
            studentFeesOrder.setOrderid(order.get("id"));
            studentFeesOrder.setDate("25-03-2003");
            studentFeesOrder.setClassname(student.getClassname());
            studentFeesOrder.setAmmount(paymentDetail.getAmmount());

            // save the order
            GeneratedFeesOrders addedOrder = this.FeesOrderRepository.save(studentFeesOrder);
            // set the generated order in response object
            this.paymentOrderResponse.setOrder(order.toString());
            this.paymentOrderResponse.setInternateConnection(false);
        } catch (Exception e) {
            e.printStackTrace();
            this.paymentOrderResponse.setInternateConnection(true);
        }

        return ResponseEntity.ok(this.paymentOrderResponse);
    }

    // save the student fees details after successfull pay fees online
    @PostMapping("/save-payment")
    public ResponseEntity<?> saveStudentFeesDetails(@RequestBody PaidFeesDetailsHeader paidFeesDetailsHeader) {
        var token = paidFeesDetailsHeader.getToken();
        StudentEcampusProfileSchema validStudent = null;
        try {
            var username = this.getTokenDetailsFromToken.getUser(token);
            if (username != null) {
                validStudent = this.studentEcampusProfileRepo.findByEnrollment(username);
            } else {
                this.paidFeesResponse.setStudentIsInvalid(true);
                this.paidFeesResponse.setFeesPaySuccessfull(false);
                this.paidFeesResponse.setSomethingwentwrong(true);
                this.paidFeesResponse.setFeesModel(null);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        // set the payer id

        // create an date with formate
        Date date = new Date();
        SimpleDateFormat myFormate = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = myFormate.format(date);
        // save the paid fees details
        SixClassStudentsFeesModel studentFeesModel = new SixClassStudentsFeesModel();
        studentFeesModel.setTotalfees(validStudent.getStudentCategory().getTotalFees());
        studentFeesModel.setDate(formattedDate);
        studentFeesModel.setOrderid(paidFeesDetailsHeader.getOrderid());
        studentFeesModel.setPaymentid(paidFeesDetailsHeader.getPaymentid());
        studentFeesModel.setPaidfees(paidFeesDetailsHeader.getAmmount());
        studentFeesModel.setUsername(validStudent.getEnrollment());
        studentFeesModel.setStudent(validStudent);

        // set the student fees details
        int stuentTotalFees = Integer.parseInt(validStudent.getStudentCategory().getTotalFees());

        // get the student all fees recipt details
        List<SixClassStudentsFeesModel> feesRecipts = this.paidFeesRepository
                .findByUsername(validStudent.getEnrollment());
        int pastPaidFees = 0;
        int totalFees = Integer.parseInt(validStudent.getStudentCategory().getTotalFees());
        int currentPayingAmmount = Integer.parseInt(paidFeesDetailsHeader.getAmmount());
        for (SixClassStudentsFeesModel prevRecord : feesRecipts) {
            pastPaidFees += Integer.parseInt(prevRecord.getPaidfees());
        }
        int totalPaidFees = pastPaidFees + currentPayingAmmount;
        int dueFees = totalFees - totalPaidFees;
        // create Student fees details class table
        StudentFeesDetails studentPastFeesDetails = validStudent.getFeesDetails();
        // create a new updated student feesdetails object and save it
        StudentFeesDetails studentFeesDetails = new StudentFeesDetails();
        studentFeesDetails.setFeesDetailsId(studentPastFeesDetails.getFeesDetailsId());
        studentFeesDetails.setPaidfees(String.valueOf(totalPaidFees));
        studentFeesDetails.setDuefees(String.valueOf(dueFees));
        studentFeesDetails.setTotalfees(String.valueOf(totalFees));

        // studentFeesModel.setStudent(validStudent);
        studentFeesModel.setDuefees(String.valueOf(dueFees));
        SixClassStudentsFeesModel feesRecord = null;
        try {
            // save the paid fees record
            feesRecord = this.paidFeesRepository.save(studentFeesModel);
            // save the student fees details
            StudentFeesDetails savedFeesDetails = this.studentFeesDetailsRepo.save(studentFeesDetails);
            // set the response object
            if (feesRecord != null && savedFeesDetails != null) {
                this.paidFeesResponse.setFeesPaySuccessfull(true);
                this.paidFeesResponse.setSomethingwentwrong(false);
                this.paidFeesResponse.setFeesModel(feesRecord);

            } else {
                this.paidFeesResponse.setFeesPaySuccessfull(false);
                this.paidFeesResponse.setSomethingwentwrong(true);
                this.paidFeesResponse.setFeesModel(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.paidFeesResponse.setFeesPaySuccessfull(false);
            this.paidFeesResponse.setSomethingwentwrong(true);
            this.paidFeesResponse.setFeesModel(null);
        }

        return ResponseEntity.ok(this.paidFeesResponse);
    }

    @GetMapping("/getdetails/{token}")
    public ResponseEntity<?> GetFeesDetails(@PathVariable("token") String token) {

        try {
            String username = this.getTokenDetailsFromToken.getUser(token);

            if (username != null) {
                // StudentEcampusProfileSchema
                // student=this.studentEcampusProfileRepo.findByEnrollment(username);
                // get the student fees details from the student fees model
                List<SixClassStudentsFeesModel> feesDetails = this.paidFeesRepository.findByUsername(username);
                // set the response object
                this.feesDetailsResponse.setFeesDetails(feesDetails);
                this.feesDetailsResponse.setSomethingWentWrong(false);
                this.feesDetailsResponse.setTokenIsInvalid(false);

            } else {
                this.feesDetailsResponse.setFeesDetails(null);
                this.feesDetailsResponse.setSomethingWentWrong(true);
                this.feesDetailsResponse.setTokenIsInvalid(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.feesDetailsResponse.setFeesDetails(null);
            this.feesDetailsResponse.setSomethingWentWrong(true);
            this.feesDetailsResponse.setTokenIsInvalid(true);
        }

        return ResponseEntity.ok(this.feesDetailsResponse);
    }

    // get the all fees recipts of authenticate student
    @GetMapping("/getfees-recipts/{token}")
    public ResponseEntity<?> GetFeesRecipts(@PathVariable("token") String token) {
        try {
            // get the username from given token
            String username = this.getTokenDetailsFromToken.getUser(token);
            if(username!=null){
                List<SixClassStudentsFeesModel> feesRecipts = this.paidFeesRepository.findByUsername(username);
                // set the recipst as a response
                this.feesReciptsAPIResponse.setInvalidUser(false);
                this.feesReciptsAPIResponse.setFeesRecipts(feesRecipts);
                this.feesReciptsAPIResponse.setSomethingWentWrong(false);
            }else {
                this.feesReciptsAPIResponse.setInvalidUser(true);
                this.feesReciptsAPIResponse.setFeesRecipts(null);
                this.feesReciptsAPIResponse.setSomethingWentWrong(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.feesReciptsAPIResponse.setInvalidUser(false);
            this.feesReciptsAPIResponse.setFeesRecipts(null);
            this.feesReciptsAPIResponse.setSomethingWentWrong(true);
        }
        return ResponseEntity.ok(this.feesReciptsAPIResponse);
    }

}
