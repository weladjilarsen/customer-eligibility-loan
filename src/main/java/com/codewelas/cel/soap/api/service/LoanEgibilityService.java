package com.codewelas.cel.soap.api.service;

import com.codewelas.cel.soap.api.loaneligibility.Acknowledgement;
import com.codewelas.cel.soap.api.loaneligibility.CustomerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanEgibilityService {

    public Acknowledgement checkLoanEgibilityService(CustomerRequest customerRequest){
        Acknowledgement acknowledgement = new Acknowledgement();

        List<String> mismatchCriteriaList = acknowledgement.getCriteriaMismatch();

        if (!(customerRequest.getAge() > 30 && customerRequest.getAge() <= 60)) {
            mismatchCriteriaList.add("Person age should in between 30 to 60");
        }
        if (!(customerRequest.getYearlyIncome() > 200000)) {
            mismatchCriteriaList.add("minimum income should be more than 200000");
        }
        if (!(customerRequest.getCibilScore() > 500)) {
            mismatchCriteriaList.add("Low CIBIL Score please try after 6 month");
        }

        if (mismatchCriteriaList.size() > 0) {
            acknowledgement.setApprovedAmount(0);
            acknowledgement.setIsEligible(false);
        } else {
            acknowledgement.setApprovedAmount(500000);
            acknowledgement.setIsEligible(true);
            mismatchCriteriaList.clear();
        }
        return acknowledgement;
    }
}
