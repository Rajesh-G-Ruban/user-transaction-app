package txn.service;

import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import txn.dto.CommonResponse;
import txn.dto.TransactionDto;
import txn.dto.TransactionMapper;
import txn.model.AppUser;
import txn.model.TransactionDetails;
import txn.model.TransactionStatus;
import txn.repository.TransactionRepository;
import txn.repository.UserRepository;
import txn.security.JwtTokenProvider;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;


    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Override
    public TransactionDto createTransaction(TransactionDto dto, AppUser appUser) {

        logger.info("Creating transaction");
        TransactionDetails transaction = TransactionMapper.convertValueToDomain(dto);


        transaction.setCreatedDateTime(new Date());
        transaction.setUpdatedDateTime(new Date());
        transaction.setUser(appUser);
        transaction = transactionRepository.save(transaction);
        logger.info("Transaction created successfully with ID: {}", transaction.getId());
        return new TransactionDto(transaction);
    }

    @Override
    public List<TransactionDto> getTransactionsByDateRangeAndStatus(Date startDate, Date endDate, String status) {
        try {
            logger.info("Fetching transactions between {} and {} with status: {}", startDate, endDate, status);
            TransactionStatus transactionStatus = TransactionStatus.valueOf(status);
            List<TransactionDetails> transactionList = transactionRepository
                    .findByTxnDateTimeBetweenAndTxnStatus(startDate, endDate, transactionStatus);
            logger.info("Found {} transactions", transactionList.size());
            return TransactionDto.convertToValueList(transactionList);
        } catch (Exception e) {
            logger.info("Fetching transactions : Exception {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }



    @Override
    public CommonResponse initiateRefund(Integer transactionId) {

        logger.info("Initiating refund for transaction ID: {}", transactionId);

        try {

            Optional<TransactionDetails> optionalTransaction = transactionRepository.findById(transactionId);

            if (optionalTransaction.isEmpty()) {
                logger.warn("Transaction with ID {} not found.", transactionId);
                throw new RuntimeException("txn.not.found");
            }

            TransactionDetails transaction = optionalTransaction.get();

            if (transaction.getTxnStatus() != TransactionStatus.SUCCESSFUL) {
                logger.warn("Refund cannot be initiated. Transaction ID {} status is not successful.", transactionId);
                return new CommonResponse(HttpStatus.NOT_FOUND.value(),
                        "Refund cannot be initiated. Transaction is not successful.");
            }
            transaction.setTxnStatus(TransactionStatus.REFUND_INITIATED);
            transaction.setUpdatedDateTime(new Date());

            transactionRepository.save(transaction);

            logger.info("Refund initiated successfully for transaction ID: {}", transactionId);

            String sucMsg = "Refund initiated successfully for transaction ID " + transactionId;
            return new CommonResponse(HttpStatus.CREATED.value(), sucMsg);
        } catch (Exception e) {
            logger.info("Exception occurred {} " , e.getMessage() );
            throw new RuntimeException(e);
        }
    }

}
