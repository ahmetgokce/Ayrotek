package ayrotek.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class AyrotekResponse<T> {

    private String exceptionMessage;
    private Boolean status;
    private T resultObject;
    private String message = "Success";

    public AyrotekResponse(boolean status, T resultObject){
        this.status = status;
        this.resultObject = resultObject;
        if (!status) { message = "Error"; }
    }
}
