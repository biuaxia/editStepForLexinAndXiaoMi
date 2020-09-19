package cn.biuaxia.code.sport.lexin.exception.handler;

import cn.biuaxia.code.sport.lexin.core.JsonResult;
import cn.biuaxia.code.sport.lexin.exception.IException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Rest统一异常处理类
 *
 * @author biuaxia
 * @date 2020-09-19 19:43:29
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public JsonResult errorHandler(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        // 对不同错误进行不同处理
        if (ex instanceof IException) {
            return JsonResult.error(((IException) ex).getCode(), ex.getMessage());
        }
        log.error(ex.getMessage(), ex);
        return JsonResult.error(ex.getMessage());
    }

}
