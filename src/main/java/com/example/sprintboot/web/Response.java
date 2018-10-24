package com.example.sprintboot.web;

import java.util.List;

public class Response {
    private String result;
    private String message;
    private List<Response> data;

    public List<Response> getData() {
        return data;
    }

    public void setData(List<Response> data) {
        this.data = data;
    }

    public Response(String result, String message) {
        this.result = result;
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Response{" +
                "result='" + result + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
