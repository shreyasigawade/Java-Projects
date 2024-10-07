package com.example.springboot_firebase_demo.constant;

public enum ApiError {
    DB_CONNECTION_ERROR("1001", "Error connecting to the database"),
    INVALID_PRODUCT_SEARCH_REQUESTFILTER("1002", "Invalid search filter for product");
    private String errorCode;
    private String msg;


    ApiError(String errorCode, String msg ) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
