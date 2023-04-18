package api.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EndPoint {

    GET_AUTHORIZED_ACCOUNT("/Account/v1/Authorized");
    private final String value;


}
