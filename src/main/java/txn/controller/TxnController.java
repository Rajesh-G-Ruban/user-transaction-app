package txn.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import txn.dto.CommonResponse;
import txn.dto.TransactionDto;
import txn.dto.TxnHistoryRequest;
import txn.dto.UserResponseDTO;
import txn.model.AppUser;
import txn.repository.UserRepository;
import txn.security.JwtTokenProvider;
import txn.service.AppUserService;
import txn.service.TransactionService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/txn-app/txn")
@RequiredArgsConstructor
public class TxnController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    UserRepository userRepository;


    @Autowired
    JwtTokenProvider jwtTokenProvider;


    private static final Logger logger = LoggerFactory.getLogger(TxnController.class);


    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @PostMapping("/post")
    public CommonResponse postTxn(@RequestBody @Valid TransactionDto transactionDto,
                                  HttpServletRequest req,
                                  BindingResult result) {

        logger.info("Received api:post txn");
        try {
            if (result.hasErrors()) {
                StringBuilder errorMessages = new StringBuilder();
                result.getAllErrors().forEach(error -> {
                    errorMessages.append(error.getDefaultMessage());
                });
                return new CommonResponse(HttpStatus.BAD_REQUEST.value(), errorMessages.toString());
            }
            AppUser appUser =   userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
            TransactionDto transaction = transactionService.createTransaction(transactionDto, appUser);

            logger.info("Transaction processed successfully, transaction ID: {}", transaction.getId());
            return new CommonResponse(HttpStatus.CREATED.value(), "success");

        } catch (Exception e) {
            return new CommonResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        }
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/history")
    public List<TransactionDto> getTransactions(@RequestBody TxnHistoryRequest request
    ) {
        logger.info("Received api: history txn");
        return transactionService.getTransactionsByDateRangeAndStatus(request.getTxnStartDate(),
                request.getTxnEndDate(),request.getTxnStatus());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("ini-refund/{transactionId}")
    public CommonResponse initiateRefund(@PathVariable Integer transactionId) {

        logger.info("Received request to initiate refund for transaction ID: {}", transactionId);
        return transactionService.initiateRefund(transactionId);
    }

}
