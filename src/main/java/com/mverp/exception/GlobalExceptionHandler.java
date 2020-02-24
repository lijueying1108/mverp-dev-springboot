package com.mverp.exception;


import com.mverp.common.dto.ResponseBean;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     *Role UnauthorizedException 권한
     * @param  ex
     * @return respBean
     */
    @ExceptionHandler(value = UnauthorizedException.class)
    public ResponseBean unauthorizedExceptionHandler(UnauthorizedException ex) {
        ResponseBean respBean = new ResponseBean();
        respBean.setStatus(false);
        respBean.setMsg("권한 부족합니다.");
        respBean.setCode("20000");
        return respBean;
    }

    /**
     *로그인
     * @param  ex
     * @return respBean
     */
    @ExceptionHandler(value = UnauthenticatedException.class)
    public ResponseBean unauthenticatedExceptionHandler(UnauthenticatedException ex) {
        ResponseBean respBean = new ResponseBean();
        respBean.setStatus(false);
        respBean.setMsg("Login");
        respBean.setCode("20000");
        return respBean;
    }

    /**
     *404 NoHandlerFoundException
     * @param  ex
     * @return respBean
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ResponseBean noHandlerFoundExceptionHandler(NoHandlerFoundException ex) {
        ResponseBean respBean = new ResponseBean();
        respBean.setStatus(false);
        respBean.setMsg("주소 찾을 수 없습니다.");
        respBean.setCode("20000");
        return respBean;
    }

    /**
     *IOException
     * @param  ex
     * @return respBean
     */
    @ExceptionHandler(value = IOException.class)
    public ResponseBean ioExceptionHandler(IOException ex) {
        ResponseBean respBean = new ResponseBean();
        respBean.setStatus(false);
        respBean.setMsg("IOException Error!");
        respBean.setCode("20000");
        return respBean;
    }

    /**
     *NullPointerException
     * @param  ex
     * @return respBean
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseBean nullPointerExceptionHandler(NullPointerException ex) {
        ResponseBean respBean = new ResponseBean();
        respBean.setStatus(false);
        respBean.setMsg("NullPointerException Error!");
        respBean.setCode("20000");
        return respBean;
    }

    /**
     *ClassCastException
     * @param  ex
     * @return respBean
     */
    @ExceptionHandler(value = ClassCastException.class)
    public ResponseBean classCastExceptionHandler(ClassCastException ex) {
        ResponseBean respBean = new ResponseBean();
        respBean.setStatus(false);
        respBean.setMsg("ClassCastException  Error!");
        respBean.setCode("20000");
        return respBean;
    }

    /**
     *ClassCastException
     * @param  ex
     * @return respBean
     */
    @ExceptionHandler(value = NoSuchMethodException.class)
    public ResponseBean noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        ResponseBean respBean = new ResponseBean();
        respBean.setStatus(false);
        respBean.setMsg("NoSuchMethodException  Error!");
        respBean.setCode("20000");
        return respBean;
    }

    /**
     *ClassCastException
     * @param  ex
     * @return respBean
     */
    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    public ResponseBean indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        ResponseBean respBean = new ResponseBean();
        respBean.setStatus(false);
        respBean.setMsg("IndexOutOfBoundsException  Error!");
        respBean.setCode("20000");
        return respBean;
    }

    /**
     *HttpMessageNotReadableException
     * @param  ex
     * @return respBean
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseBean httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException ex) {
        ResponseBean respBean = new ResponseBean();
        respBean.setStatus(false);
        respBean.setMsg("IndexOutOfBoundsException  Error!");
        respBean.setCode("20000");
        return respBean;
    }

    /**
     *HttpRequestMethodNotSupportedException
     * @param  ex
     * @return respBean
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseBean httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException ex) {
        ResponseBean respBean = new ResponseBean();
        respBean.setStatus(false);
        respBean.setMsg("HttpRequestMethodNotSupportedException  Error!");
        respBean.setCode("20000");
        return respBean;
    }

    /**
     *HttpMediaTypeNotAcceptableException
     * @param  ex
     * @return respBean
     */
    @ExceptionHandler(value = HttpMediaTypeNotAcceptableException.class)
    public ResponseBean httpMediaTypeNotAcceptableExceptionHandler(HttpMediaTypeNotAcceptableException ex) {
        ResponseBean respBean = new ResponseBean();
        respBean.setStatus(false);
        respBean.setMsg("HttpMediaTypeNotAcceptableException  Error!");
        respBean.setCode("20000");
        return respBean;
    }

    /**
     *HttpMediaTypeNotAcceptableException
     * @param  ex
     * @return respBean
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseBean methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        ResponseBean respBean = new ResponseBean();
        respBean.setStatus(false);
        respBean.setMsg("MethodArgumentNotValidException  Error!");
        respBean.setCode("20000");
        return respBean;
    }

    /**
     *ConstraintViolationException
     * @param  ex
     * @return respBean
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseBean constraintViolationExceptionHandler(ConstraintViolationException ex) {
        ResponseBean respBean = new ResponseBean();
        respBean.setStatus(false);
        respBean.setMsg("ConstraintViolationException  Error!");
        respBean.setCode("20000");
        return respBean;
    }

    /**
     *RuntimeException
     * @param  ex
     * @return respBean
     */
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseBean runtimeExceptionHandler(RuntimeException ex) {
        ResponseBean respBean = new ResponseBean();
        respBean.setStatus(false);
        respBean.setMsg("RuntimeException  Error!");
        respBean.setCode("20000");
        return respBean;
    }

    /**
     *RuntimeException
     * @param  ex
     * @return respBean
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseBean otherExceptionHandler(Exception ex) {
        ResponseBean respBean = new ResponseBean();
        respBean.setStatus(false);
        respBean.setMsg("Exception   Error!");
        respBean.setCode("20000");
        return respBean;
    }

    /**
     *RuntimeException
     * @param  ex
     * @return respBean
     */
    @ExceptionHandler(value = Throwable.class)
    public ResponseBean otherThrowableHandler(Throwable ex) {
        ResponseBean respBean = new ResponseBean();
        respBean.setStatus(false);
        respBean.setMsg("Throwable   Error!");
        respBean.setCode("20000");
        return respBean;
    }


}
