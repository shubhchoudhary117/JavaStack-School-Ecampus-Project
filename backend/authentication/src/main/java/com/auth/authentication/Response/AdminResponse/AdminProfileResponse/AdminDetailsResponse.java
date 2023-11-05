package com.auth.authentication.Response.AdminResponse.AdminProfileResponse;

import org.springframework.stereotype.Component;
import com.auth.authentication.Entities.AdminModel.*;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
@Component
@Data
@RequiredArgsConstructor
@ToString
public class AdminDetailsResponse {
    
    private Boolean AdminNotFound;
    private AdminSchema adminDetails;

}
