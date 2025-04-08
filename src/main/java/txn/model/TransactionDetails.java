package txn.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;


@Entity
@Table(name = "txn_details")
public class TransactionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bank_code")
    private String bankCode;

    @Column(name = "network")
    private String network;

    @Column(name = "unique_id")
    private String uniqueId;

    @Column(name = "mti")
    private String mti;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "token_identifier")
    private String tokenIdentifier;

    @Column(name = "amount_transaction")
    private BigDecimal amountTransaction;

    @Column(name = "txn_date_time")
    private Date txnDateTime;

    @Column(name = "stan")
    private String stan;

    @Column(name = "local_txn_time")
    private LocalTime localTxnTime;

    @Column(name = "local_txn_date")
    private Date localTxnDate;

    @Column(name = "expiry_date")
    private Date expiryDate;

    @Column(name = "mcc")
    private String mcc;

    @Column(name = "ret_ref_number")
    private String retRefNumber;

    @Column(name = "service_restriction_code")
    private String serviceRestrictionCode;

    @Column(name = "card_acceptor_tid")
    private String cardAcceptorTid;

    @Column(name = "card_acceptor_id")
    private String cardAcceptorId;

    @Column(name = "card_acceptor_name")
    private String cardAcceptorName;

    @Column(name = "card_acceptor_street_address")
    private String cardAcceptorStreetAddress;

    @Column(name = "card_acceptor_city")
    private String cardAcceptorCity;

    @Column(name = "card_acceptor_state_code")
    private String cardAcceptorStateCode;

    @Column(name = "card_acceptor_country_code")
    private String cardAcceptorCountryCode;

    @Column(name = "card_acceptor_pin_code")
    private String cardAcceptorPinCode;

    @Column(name = "txn_currency_code")
    private String txnCurrencyCode;

    @Column(name = "txn_source")
    private String txnSource;

    @Column(name = "txn_status")
    @Enumerated(EnumType.STRING)
    private TransactionStatus txnStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

    @Column(name = "created_date_time")
    private Date createdDateTime;

    @Column(name = "updated_date_time")
    private Date updatedDateTime;

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Date getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(Date updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getMti() {
        return mti;
    }

    public void setMti(String mti) {
        this.mti = mti;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getTokenIdentifier() {
        return tokenIdentifier;
    }

    public void setTokenIdentifier(String tokenIdentifier) {
        this.tokenIdentifier = tokenIdentifier;
    }

    public BigDecimal getAmountTransaction() {
        return amountTransaction;
    }

    public void setAmountTransaction(BigDecimal amountTransaction) {
        this.amountTransaction = amountTransaction;
    }

    public Date getTxnDateTime() {
        return txnDateTime;
    }

    public void setTxnDateTime(Date txnDateTime) {
        this.txnDateTime = txnDateTime;
    }

    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    public LocalTime getLocalTxnTime() {
        return localTxnTime;
    }

    public void setLocalTxnTime(LocalTime localTxnTime) {
        this.localTxnTime = localTxnTime;
    }

    public Date getLocalTxnDate() {
        return localTxnDate;
    }

    public void setLocalTxnDate(Date localTxnDate) {
        this.localTxnDate = localTxnDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getRetRefNumber() {
        return retRefNumber;
    }

    public void setRetRefNumber(String retRefNumber) {
        this.retRefNumber = retRefNumber;
    }

    public String getServiceRestrictionCode() {
        return serviceRestrictionCode;
    }

    public void setServiceRestrictionCode(String serviceRestrictionCode) {
        this.serviceRestrictionCode = serviceRestrictionCode;
    }

    public String getCardAcceptorTid() {
        return cardAcceptorTid;
    }

    public void setCardAcceptorTid(String cardAcceptorTid) {
        this.cardAcceptorTid = cardAcceptorTid;
    }

    public String getCardAcceptorId() {
        return cardAcceptorId;
    }

    public void setCardAcceptorId(String cardAcceptorId) {
        this.cardAcceptorId = cardAcceptorId;
    }

    public String getCardAcceptorName() {
        return cardAcceptorName;
    }

    public void setCardAcceptorName(String cardAcceptorName) {
        this.cardAcceptorName = cardAcceptorName;
    }

    public String getCardAcceptorStreetAddress() {
        return cardAcceptorStreetAddress;
    }

    public void setCardAcceptorStreetAddress(String cardAcceptorStreetAddress) {
        this.cardAcceptorStreetAddress = cardAcceptorStreetAddress;
    }

    public String getCardAcceptorCity() {
        return cardAcceptorCity;
    }

    public void setCardAcceptorCity(String cardAcceptorCity) {
        this.cardAcceptorCity = cardAcceptorCity;
    }

    public String getCardAcceptorStateCode() {
        return cardAcceptorStateCode;
    }

    public void setCardAcceptorStateCode(String cardAcceptorStateCode) {
        this.cardAcceptorStateCode = cardAcceptorStateCode;
    }

    public String getCardAcceptorCountryCode() {
        return cardAcceptorCountryCode;
    }

    public void setCardAcceptorCountryCode(String cardAcceptorCountryCode) {
        this.cardAcceptorCountryCode = cardAcceptorCountryCode;
    }

    public String getCardAcceptorPinCode() {
        return cardAcceptorPinCode;
    }

    public void setCardAcceptorPinCode(String cardAcceptorPinCode) {
        this.cardAcceptorPinCode = cardAcceptorPinCode;
    }

    public String getTxnCurrencyCode() {
        return txnCurrencyCode;
    }

    public void setTxnCurrencyCode(String txnCurrencyCode) {
        this.txnCurrencyCode = txnCurrencyCode;
    }

    public String getTxnSource() {
        return txnSource;
    }

    public void setTxnSource(String txnSource) {
        this.txnSource = txnSource;
    }

    public TransactionStatus getTxnStatus() {
        return txnStatus;
    }

    public void setTxnStatus(TransactionStatus txnStatus) {
        this.txnStatus = txnStatus;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }
}
