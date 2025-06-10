package com.RewardProgram.demo.service;

        import com.RewardProgram.demo.entity.Transaction;
        import com.RewardProgram.demo.DTO.RewardResponseDto;
        import org.springframework.stereotype.Service;

        import java.math.BigDecimal;
        import java.time.YearMonth;
        import java.util.*;
        import java.util.stream.Collectors;

/*Service class to calculate reward points for customers based on their transactions. */
@Service
public class RewardService {

//    public List<RewardResponseDto> calculateRewards(double transactions)
    public List<RewardResponseDto> calculateRewards(List<Transaction> transactions)

    {
        Map<String, Map<YearMonth, Integer>> customerMonthlyPoints = new HashMap<>();

        for (Transaction transaction : transactions) {
            String customerId = transaction.getCustomerId();
            YearMonth month = YearMonth.from(transaction.getTransactionDate());
            int points = calculatePoints(transaction.getAmount());

            customerMonthlyPoints
                    .computeIfAbsent(customerId, k -> new HashMap<>())
                    .merge(month, points, Integer::sum);
        }

        return customerMonthlyPoints.entrySet().stream()
                .map(entry -> {
                    String customerId = entry.getKey();
                    Map<YearMonth, Integer> monthlyPoints = entry.getValue();
                    int totalPoints = monthlyPoints.values().stream().mapToInt(Integer::intValue).sum();
                    return new RewardResponseDto(customerId, monthlyPoints, totalPoints);
                })
                .collect(Collectors.toList());
    }


    private int calculatePoints(int amount) {
        int points = 0;
        if (amount > 100) {
            points += (amount - 100) * 2;
            amount = 100;
        }
        if (amount > 50) {
            points += (amount - 50);
        }
        return points;
    }
}
