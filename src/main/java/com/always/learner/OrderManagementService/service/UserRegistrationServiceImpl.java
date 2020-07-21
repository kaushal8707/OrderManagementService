package com.always.learner.OrderManagementService.service;
import com.always.learner.OrderManagementService.dto.SellerDto;
import com.always.learner.OrderManagementService.service.hystrix.UserRegistrationHystrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    Logger logger = LoggerFactory.getLogger(UserRegistrationServiceImpl.class);
    private UserRegistrationHystrix userRegistrationHystrix;

    public UserRegistrationServiceImpl(UserRegistrationHystrix userRegistrationHystrix) {
        this.userRegistrationHystrix = userRegistrationHystrix;
    }

    @Override
    public String registerSeller(SellerDto sellerDto) {
        long start = System.currentTimeMillis();
        String registerSeller = userRegistrationHystrix.registerSeller(sellerDto);
        logger.info("add seller call returned in - {}", System.currentTimeMillis() - start);
        return registerSeller;
    }

    @Override
    public List<SellerDto> getSellersList() {
        return userRegistrationHystrix.getSellersList();
    }
}