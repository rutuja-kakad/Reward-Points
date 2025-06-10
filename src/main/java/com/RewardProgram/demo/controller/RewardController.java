package com.RewardProgram.demo.controller;

import com.RewardProgram.demo.DTO.RewardResponseDto;
import com.RewardProgram.demo.entity.Transaction;
import com.RewardProgram.demo.repository.TransactionRepository;
import com.RewardProgram.demo.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @Autowired
    private TransactionRepository transactionRepository;


//    @GetMapping("/api/rewards")
//    public List<RewardResponseDto> getRewards(double amount) {
//        return rewardService.calculateRewards(amount);
//    }

    @GetMapping("/api/rewards")
    public List<RewardResponseDto> getRewards() {
        List<Transaction> transactions = transactionRepository.findAll();
        return rewardService.calculateRewards(transactions);
    }

}

