package org.example.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString(callSuper = true)
public class ErrorResponseDTO extends RuntimeException {

    private String username;
    private String typeUser;

    public ErrorResponseDTO(String message, Throwable cause, String username, String typeUser) {
        super(message, cause);
        this.username = username;
        this.typeUser = typeUser;
    }
}
