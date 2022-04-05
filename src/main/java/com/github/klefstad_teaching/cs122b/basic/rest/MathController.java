package com.github.klefstad_teaching.cs122b.basic.rest;

import com.github.klefstad_teaching.cs122b.basic.config.BasicServiceConfig;
import com.github.klefstad_teaching.cs122b.basic.request.MathRequest;
import com.github.klefstad_teaching.cs122b.basic.response.MathResponse;
import com.github.klefstad_teaching.cs122b.basic.util.Validate;
import com.github.klefstad_teaching.cs122b.core.error.ResultError;
import com.github.klefstad_teaching.cs122b.core.result.BasicResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController extends BasicController{

    @Autowired
    public MathController(BasicServiceConfig config, Validate validate) {
        super(config, validate);
    }

    @PostMapping("/math")
    public ResponseEntity<MathResponse> math(
            @RequestBody MathRequest request)
    {
            if (!request.allNumbersSet()) {
                throw new ResultError(BasicResults.DATA_CONTAINS_MISSING_INTEGERS);
            }

            if ( !(request.xInBounds() && request.yInBounds() && request.zInBounds()) ) {
                throw new ResultError(BasicResults.DATA_CONTAINS_INVALID_INTEGERS);
            }

            MathResponse body = new MathResponse().setValue(request.getValue()).validResult();

            return ResponseEntity.status(HttpStatus.OK).body(body);

    }
}
