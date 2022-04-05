package com.github.klefstad_teaching.cs122b.basic.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.klefstad_teaching.cs122b.basic.config.BasicServiceConfig;
import com.github.klefstad_teaching.cs122b.basic.response.ReverseResponse;
import com.github.klefstad_teaching.cs122b.basic.util.Validate;
import com.github.klefstad_teaching.cs122b.core.error.ResultError;
import com.github.klefstad_teaching.cs122b.core.result.BasicResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@JsonInclude(JsonInclude.Include.NON_NULL)
@RestController
public class ReverseController extends BasicController{

    @Autowired
    public ReverseController(BasicServiceConfig config, Validate validate) {
        super(config, validate);
    }

    @GetMapping("/reverse/{message}")
    public ResponseEntity<ReverseResponse> reverse(
            @PathVariable String message)
    {
        if (message.trim().isEmpty()) {
            throw new ResultError(BasicResults.STRING_IS_EMPTY);
        }

        if (!ReverseResponse.reverseValid(message)) {
            throw new ResultError(BasicResults.STRING_CONTAINS_INVALID_CHARACTERS);
        }
        ReverseResponse body = new ReverseResponse(message);

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
}
