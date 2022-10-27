package com.briup.cms.exception;

import com.briup.cms.utils.ResultCode;

public class ServiceException extends RuntimeException {


    private ResultCode resultCode;

    public ServiceException(ResultCode resultCode){
        super(resultCode.message());
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
