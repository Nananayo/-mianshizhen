package com.zizhen.mianshizhen.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotRoleException;
import com.zizhen.mianshizhen.common.BaseResponse;
import com.zizhen.mianshizhen.common.ErrorCode;
import com.zizhen.mianshizhen.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author <a href="https://github.com/lizizhen">程序员鱼皮</a>
 * @from <a href="https://zizhen.icu">编程导航知识星球</a>
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public BaseResponse<?> businessExceptionHandler(BusinessException e) {
        log.error("BusinessException", e);
        return ResultUtils.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse<?> runtimeExceptionHandler(RuntimeException e) {
        log.error("RuntimeException", e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "系统错误");
    }
    @ExceptionHandler(NotRoleException.class)
    public BaseResponse<?> notRoleExceptionHandler(RuntimeException e) {
        log.error("NotRoleException", e);
        return ResultUtils.error(ErrorCode.NO_AUTH_ERROR, "无权限");
    }

    @ExceptionHandler(NotLoginException.class)
    public BaseResponse<?> notLoginExceptionHandler(RuntimeException e) {
        log.error("NotLoginException", e);
        return ResultUtils.error(ErrorCode.NOT_LOGIN_ERROR, "未登录");
    }
}

