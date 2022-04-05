package com.github.klefstad_teaching.cs122b.basic.response;

import com.github.klefstad_teaching.cs122b.core.result.BasicResults;
import com.github.klefstad_teaching.cs122b.core.result.Result;

import java.nio.charset.StandardCharsets;

public class ReverseResponse {

    private Result result;
    private String reversed;

    public String getReversed() {
        return reversed;
    }

    public void setReversed(String original) {
        String revTemp = "";
        for (int i = 0; i < original.length(); i++) {
            revTemp = original.charAt(i) + revTemp;
        }
        this.reversed = revTemp;
    }

    public Result getResult() {
        return result;
    }

    public ReverseResponse(String original) {
        setReversed(original);
        result = BasicResults.STRING_SUCCESSFULLY_REVERSED;
    }

    public static boolean reverseValid(String str) {
        return !str.matches("(.*)[^a-zA-Z\\d\\s_](.*)");
    }
}
