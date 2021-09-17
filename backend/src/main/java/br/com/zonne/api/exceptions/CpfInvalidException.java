package br.com.zonne.api.exceptions;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CpfInvalidException extends ServiceException {

    public CpfInvalidException(String message) {
        super(message);
    }
}
