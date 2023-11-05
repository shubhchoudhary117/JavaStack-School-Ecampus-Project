package com.auth.authentication.Response.FeesPayResponses;

import java.util.List;

import org.springframework.stereotype.Component;

import com.auth.authentication.Entities.FeesModels.StudentsFeesModels.SixClassStudentsFeesModel;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@Component
@ToString
public class FeesReciptsAPIResponse {
    private boolean InvalidUser;
    private List<SixClassStudentsFeesModel> feesRecipts;
    private boolean SomethingWentWrong;
}
