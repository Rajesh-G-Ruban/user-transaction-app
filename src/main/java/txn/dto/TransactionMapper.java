package txn.dto;

import txn.model.TransactionDetails;

public class TransactionMapper {

    public static TransactionDetails convertValueToDomain(TransactionDto transactionDto) {
        TransactionDetails transaction = new TransactionDetails();
        
        transaction.setId(transactionDto.getId());
        transaction.setBankCode(transactionDto.getBankCode());
        transaction.setNetwork(transactionDto.getNetwork());
        transaction.setUniqueId(transactionDto.getUniqueId());
        transaction.setMti(transactionDto.getMti());
        transaction.setCardNumber(transactionDto.getCardNumber());
        transaction.setTokenIdentifier(transactionDto.getTokenIdentifier());
        transaction.setAmountTransaction(transactionDto.getAmountTransaction());
        transaction.setTxnDateTime(transactionDto.getTxnDateTime());
        transaction.setStan(transactionDto.getStan());
        transaction.setLocalTxnTime(transactionDto.getLocalTxnTime());
        transaction.setLocalTxnDate(transactionDto.getLocalTxnDate());
        transaction.setExpiryDate(transactionDto.getExpiryDate());
        transaction.setMcc(transactionDto.getMcc());
        transaction.setRetRefNumber(transactionDto.getRetRefNumber());
        transaction.setServiceRestrictionCode(transactionDto.getServiceRestrictionCode());
        transaction.setCardAcceptorTid(transactionDto.getCardAcceptorTid());
        transaction.setCardAcceptorId(transactionDto.getCardAcceptorId());
        transaction.setCardAcceptorName(transactionDto.getCardAcceptorName());
        transaction.setCardAcceptorStreetAddress(transactionDto.getCardAcceptorStreetAddress());
        transaction.setCardAcceptorCity(transactionDto.getCardAcceptorCity());
        transaction.setCardAcceptorStateCode(transactionDto.getCardAcceptorStateCode());
        transaction.setCardAcceptorCountryCode(transactionDto.getCardAcceptorCountryCode());
        transaction.setCardAcceptorPinCode(transactionDto.getCardAcceptorPinCode());
        transaction.setTxnCurrencyCode(transactionDto.getTxnCurrencyCode());
        transaction.setTxnSource(transactionDto.getTxnSource());
        transaction.setTxnStatus(transactionDto.getTxnStatus());
        
        return transaction;
    }
}
