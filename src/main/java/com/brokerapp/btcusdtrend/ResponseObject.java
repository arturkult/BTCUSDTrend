package com.brokerapp.btcusdtrend;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
public class ResponseObject {
    @JsonProperty("time")
    @Getter
    @Setter
    private String time;
    @JsonProperty("average")
    @Getter
    @Setter
    private Double average;

}
