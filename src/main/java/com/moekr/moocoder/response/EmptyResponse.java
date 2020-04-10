package com.moekr.moocoder.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moekr.moocoder.response.Response;
import lombok.Data;

@Data
public class EmptyResponse implements Response {
    @JsonProperty("code")
    private int error;

    public EmptyResponse() {
        this.error = 0;
    }

    protected EmptyResponse(int error) {
        this.error = error;
    }
}
