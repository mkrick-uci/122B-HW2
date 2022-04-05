package com.github.klefstad_teaching.cs122b.basic.response;

import com.github.klefstad_teaching.cs122b.core.result.BasicResults;
import com.github.klefstad_teaching.cs122b.core.result.Result;

public class MathResponse {

    private Result result;
    private Integer value;

    public Result getResult() {
        return result;
    }

    public MathResponse validResult() {
        this.result = BasicResults.CALCULATION_SUCCESSFUL;
        return this;
    }

    public Integer getValue() {
        return value;
    }

    public MathResponse setValue(Integer value) {
        this.value = value;
        return this;
    }


}
