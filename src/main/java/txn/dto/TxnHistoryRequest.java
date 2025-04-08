package txn.dto;

import lombok.Data;
import java.util.Date;

@Data
public class TxnHistoryRequest {
    Date txnStartDate;
    Date txnEndDate;
    String txnStatus;
}
