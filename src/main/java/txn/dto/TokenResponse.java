package txn.dto;

import lombok.Data;

@Data
public class TokenResponse extends CommonResponse {

    String token;

    public TokenResponse(String token, Integer errCode, String msg) {
        super(errCode, msg);
        this.token = token;
    }
}
