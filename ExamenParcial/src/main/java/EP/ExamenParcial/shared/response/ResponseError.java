package EP.ExamenParcial.shared.response;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseError {
    private Date time = new Date();
    private String message;
    private Integer status;
    private String url;

    public ResponseError(String message,Integer status, String url) {
        this.message = message;
        this.status = status;
        this.url = url.replace("uri=", "");
    }
 
}
