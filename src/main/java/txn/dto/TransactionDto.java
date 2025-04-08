package txn.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import txn.model.TransactionDetails;
import txn.model.TransactionStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
public class TransactionDto {

    Integer id;

    @NotNull(message = "Bank code cannot be null")
    @Size(min = 3, max = 6, message = "Bank code must be between 3 and 6 characters")
    private String bankCode;

    @NotNull(message = "Network cannot be null")
    @Size(min = 3, max = 15, message = "Network must be between 3 and 15 characters")
    private String network;

    @NotNull(message = "Unique ID cannot be null")
    private String uniqueId;

    @NotNull(message = "MTI cannot be null")
    @Size(min = 4, max = 4, message = "MTI must be 4 characters")
    private String mti;

    @NotNull(message = "Card number cannot be null")
    @Size(min = 13, max = 19, message = "Card number must be between 13 and 19 characters")
    private String cardNumber;

    private String tokenIdentifier;

    @NotNull(message = "Amount transaction cannot be null")
    @DecimalMin(value = "0.01", message = "Amount transaction must be greater than 0")
    private BigDecimal amountTransaction;

    @NotNull(message = "Transaction date and time cannot be null")
    private Date txnDateTime;

    @NotNull(message = "STAN cannot be null")
    @Size(min = 6, max = 6, message = "STAN must be 6 characters")
    private String stan;

    private LocalTime localTxnTime;

    private Date localTxnDate;

    @NotNull(message = "Expiry date cannot be null")
    private Date expiryDate;

    @NotNull(message = "MCC cannot be null")
    @Size(min = 3, max = 4, message = "MCC must be between 3 and 4 characters")
    private String mcc;

    private String retRefNumber;

    private String serviceRestrictionCode;

    @NotNull(message = "Card Acceptor TID cannot be null")
    @Size(min = 8, max = 8, message = "Card Acceptor TID must be 8 characters")
    private String cardAcceptorTid;

    @NotNull(message = "Card Acceptor ID cannot be null")
    @Size(min = 10, max = 15, message = "Card Acceptor ID must be between 10 and 15 characters")
    private String cardAcceptorId;

    @NotNull(message = "Card Acceptor name cannot be null")
    @Size(min = 3, max = 100, message = "Card Acceptor name must be between 3 and 100 characters")
    private String cardAcceptorName;

    @NotNull(message = "Card Acceptor street address cannot be null")
    @Size(min = 5, max = 100, message = "Card Acceptor street address must be between 5 and 100 characters")
    private String cardAcceptorStreetAddress;

    @NotNull(message = "Card Acceptor city cannot be null")
    @Size(min = 3, max = 50, message = "Card Acceptor city must be between 3 and 50 characters")
    private String cardAcceptorCity;

    @NotNull(message = "Card Acceptor state code cannot be null")
    @Size(min = 2, max = 3, message = "Card Acceptor state code must be between 2 and 3 characters")
    private String cardAcceptorStateCode;

    @NotNull(message = "Card Acceptor country code cannot be null")
    @Size(min = 2, max = 3, message = "Card Acceptor country code must be between 2 and 3 characters")
    private String cardAcceptorCountryCode;

    @NotNull(message = "Card Acceptor pin code cannot be null")
    @Size(min = 3, max = 10, message = "Card Acceptor pin code must be between 3 and 10 characters")
    private String cardAcceptorPinCode;

    @NotNull(message = "Transaction currency code cannot be null")
    @Size(min = 3, max = 3, message = "Transaction currency code must be 3 characters")
    private String txnCurrencyCode;

    @NotNull(message = "Transaction source cannot be null")
    @Size(min = 2, max = 15, message = "Transaction source must be between 2 and 15 characters")
    private String txnSource;

    @Enumerated(EnumType.STRING)
    private TransactionStatus txnStatus;


    public TransactionDto(TransactionDetails transaction) {
        this.id = transaction.getId();
        this.bankCode = transaction.getBankCode();
        this.network = transaction.getNetwork();
        this.uniqueId = transaction.getUniqueId();
        this.mti = transaction.getMti();
        this.cardNumber = transaction.getCardNumber();
        this.tokenIdentifier = transaction.getTokenIdentifier();
        this.amountTransaction = transaction.getAmountTransaction();
        this.txnDateTime = transaction.getTxnDateTime();
        this.stan = transaction.getStan();
        this.localTxnTime = transaction.getLocalTxnTime();
        this.localTxnDate = transaction.getLocalTxnDate();
        this.expiryDate = transaction.getExpiryDate();
        this.mcc = transaction.getMcc();
        this.retRefNumber = transaction.getRetRefNumber();
        this.serviceRestrictionCode = transaction.getServiceRestrictionCode();
        this.cardAcceptorTid = transaction.getCardAcceptorTid();
        this.cardAcceptorId = transaction.getCardAcceptorId();
        this.cardAcceptorName = transaction.getCardAcceptorName();
        this.cardAcceptorStreetAddress = transaction.getCardAcceptorStreetAddress();
        this.cardAcceptorCity = transaction.getCardAcceptorCity();
        this.cardAcceptorStateCode = transaction.getCardAcceptorStateCode();
        this.cardAcceptorCountryCode = transaction.getCardAcceptorCountryCode();
        this.cardAcceptorPinCode = transaction.getCardAcceptorPinCode();
        this.txnCurrencyCode = transaction.getTxnCurrencyCode();
        this.txnSource = transaction.getTxnSource();
        this.txnStatus = transaction.getTxnStatus();
    }

    public static List<TransactionDto> convertToValueList(List<TransactionDetails> transactionDtos) {
        return transactionDtos.stream().map(TransactionDto::new).collect(Collectors.toList());
    }

}



