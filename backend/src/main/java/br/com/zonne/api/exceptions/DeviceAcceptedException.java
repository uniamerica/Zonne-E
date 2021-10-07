package br.com.zonne.api.exceptions;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ACCEPTED)
public class DeviceAcceptedException extends ServiceException{

    public DeviceAcceptedException(String message) {super(message);}
}
