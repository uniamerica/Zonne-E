package br.com.zonne.api.exceptions;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StreetNotFoundException extends ServiceException {

    public StreetNotFoundException(String message) {
        super(message);
    }
}