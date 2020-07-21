package com.always.learner.OrderManagementService.service;

import com.always.learner.OrderManagementService.dto.SellerDto;

import java.util.List;

public interface UserRegistrationService {
    String registerSeller(SellerDto sellerDto);
    List<SellerDto> getSellersList();
}
