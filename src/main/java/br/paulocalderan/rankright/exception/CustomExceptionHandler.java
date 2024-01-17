package br.paulocalderan.rankright.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;
import java.util.Objects;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status,
                                                                  WebRequest request) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        Locale currentLocale = LocaleContextHolder.getLocale();

        String field = messageSource.getMessage(fieldError.getField(), null, fieldError.getField(), currentLocale);
        String errorMessageCode = Objects.requireNonNull(fieldError).getCode();
        String defaultMessage = fieldError.getDefaultMessage();
        String mensagem = messageSource.getMessage(errorMessageCode, new Object[]{field}, defaultMessage, currentLocale);

        ResponseError erro = new ResponseError(mensagem);
        return handleExceptionInternal(ex, erro, headers, BAD_REQUEST, request);
    }

    @ResponseBody
    @ResponseStatus(CONFLICT)
    @ExceptionHandler(ApiException.class)
    public ResponseError handleApiException(ApiException ex) {
        return getLocalizedErrorMessage(ex);
    }

    private ResponseError getLocalizedErrorMessage(RuntimeException ex) {
        String localizedErrorMessage = messageSource.getMessage(ex.getMessage(), null, LocaleContextHolder.getLocale());
        return new ResponseError(localizedErrorMessage);
    }
}
