package com.codewelas.cel.soap.api.endpoint;

import com.codewelas.cel.soap.api.loaneligibility.Acknowledgement;
import com.codewelas.cel.soap.api.loaneligibility.CustomerRequest;
import com.codewelas.cel.soap.api.service.LoanEgibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoanEgibilityindicatorEndpoint {

    private static final String NAMESPACE = "http://www.codewelas.com/cel/soap/api/loaneligibility";

    @Autowired
    private final LoanEgibilityService loanEgibilityService;

    public LoanEgibilityindicatorEndpoint(LoanEgibilityService loanEgibilityService) {
        this.loanEgibilityService = loanEgibilityService;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
    @ResponsePayload
    public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest customerRequest) {
        return loanEgibilityService.checkLoanEgibilityService(customerRequest);
    }
}
