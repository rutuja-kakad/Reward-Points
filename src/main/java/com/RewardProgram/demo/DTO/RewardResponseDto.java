package com.RewardProgram.demo.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.YearMonth;
import java.util.Map;

@Getter
@Setter
public class RewardResponseDto {

    private String customerId;
    private String customerName;
    private Map<YearMonth, Integer> monthlyPoints;
    private int totalPoints;

    public RewardResponseDto(String customerId,
                             //String customerName,
                             Map<YearMonth, Integer> monthlyPoints, int totalPoints) {
        this.customerId = customerId;
        //this.customerName = customerName;
        this.monthlyPoints = monthlyPoints;
        this.totalPoints = totalPoints;
    }
}

