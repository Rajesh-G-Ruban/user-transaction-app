package txn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import txn.model.TransactionDetails;
import txn.model.TransactionStatus;
import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionDetails, Integer> {

    List<TransactionDetails> findByTxnDateTimeBetweenAndTxnStatus(Date startDate, Date endDate, TransactionStatus status);

}
