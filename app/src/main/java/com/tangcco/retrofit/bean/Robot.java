package com.tangcco.retrofit.bean;

/**
 * Created by Administrator on 2017/3/18.
 */

public class Robot {
    private String reason;
    private int error_code;

    @Override
    public String toString() {
        return "Robot{" +
                "reason='" + reason + '\'' +
                ", error_code=" + error_code +
                '}';
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {

        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
