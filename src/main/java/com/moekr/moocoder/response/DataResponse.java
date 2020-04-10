package com.moekr.moocoder.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DataResponse extends EmptyResponse {
    @JsonProperty("data")
    private Object data;

    public DataResponse(Object resource) {
        this.data = resource;
    }
}
