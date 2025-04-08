package txn.service;

import txn.dto.CommonResponse;
import txn.dto.TransactionDto;
import txn.model.AppUser;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface TransactionService {

    TransactionDto createTransaction(TransactionDto dto, AppUser user);

    List<TransactionDto> getTransactionsByDateRangeAndStatus(Date startDate,
                                                             Date endDate,
                                                             String status);
    CommonResponse initiateRefund(Integer transactionId);
}
