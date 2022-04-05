package com.github.klefstad_teaching.cs122b.basic.response;

import com.github.klefstad_teaching.cs122b.core.result.BasicResults;
import com.github.klefstad_teaching.cs122b.core.result.Result;

public class HelloResponse {

    private Result result;
    private String greeting;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String message) {
        this.greeting = message;
    }

    public Result getResult() {
        return result;
    }

    public HelloResponse(String message) {
        this.greeting = message;
        result = BasicResults.HELLO;
    }
}
