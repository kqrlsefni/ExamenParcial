package EP.ExamenParcial.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AlumnoException extends RuntimeException{
    private Integer status;
    public AlumnoException(String message,Integer status){
        super(message);
        this.status = status;
    }
}
