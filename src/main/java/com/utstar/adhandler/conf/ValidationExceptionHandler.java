package com.utstar.adhandler.conf;

import com.utstar.adhandler.vo.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

/**
 * @ClassName ValidationExceptionHandler
 * @Description: 参数统一验证
 * @Verson 1.0
 **/
@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    public ResponseEntity<Object> handleBindException(final BindException ex, final HttpHeaders headers,
                                                      final HttpStatus status, final WebRequest request) {

        return new ResponseEntity<>(getError(ex.getBindingResult().getAllErrors()), status);
    }

    /**
     * 解决 JSON 请求统一返回参数
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
                                                                  final HttpHeaders headers, final HttpStatus status,
                                                                  final WebRequest request) {
        return new ResponseEntity<>(getError(ex.getBindingResult().getAllErrors()), status);
    }

    private Response<String> getError(final List<ObjectError> allErrors) {

        final StringBuffer message = new StringBuffer();
        for (final ObjectError error : allErrors) {
            message.append(error.getDefaultMessage()).append("; ");
        }
        logger.error(message.toString()); // 因为&两边空格
        return Response.paramsError(message.toString());
    }
}