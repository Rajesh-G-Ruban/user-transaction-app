package txn.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommonResponse {

    Integer respCode;
    String message;

    public CommonResponse(Integer respCode, String message) {
        this.respCode = respCode;
        this.message = message;
    }
}
