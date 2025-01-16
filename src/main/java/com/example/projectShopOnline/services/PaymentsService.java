package com.example.projectShopOnline.services;

import com.example.projectShopOnline.entities.Payments;
import com.example.projectShopOnline.entities.dto.respository.PaymentsResDTO;
import com.example.projectShopOnline.mapper.PaymentsMapper;
import com.example.projectShopOnline.repository.PaymentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentsService {
    private final PaymentsRepository paymentsRepository;

    public PaymentsService(PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }

    public PaymentsResDTO savePayments(PaymentsResDTO paymentsResDTO) {
        Payments payments = PaymentsMapper.INSTANCE.toEntity(paymentsResDTO);
        Payments savePayments = paymentsRepository.save(payments);
        return PaymentsMapper.INSTANCE.toDTO(savePayments);
    }

    public PaymentsResDTO updatePayment(int id,PaymentsResDTO paymentsResDTO) {
        Payments payments = paymentsRepository.findById(id).orElse(null);
        payments.setAmount(paymentsResDTO.getAmount());
        payments.setPaymentMethod(paymentsResDTO.getPaymentMethod());
        payments = paymentsRepository.save(payments);
        return PaymentsMapper.INSTANCE.toDTO(payments);
    }

    public List<PaymentsResDTO> getAllPayments() {
        return paymentsRepository.findAll()
                .stream()
                .map(PaymentsMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public PaymentsResDTO findById(int id) {
        Payments payments =paymentsRepository.findById(id).orElse(null);
        return PaymentsMapper.INSTANCE.toDTO(payments);
    }

    public Boolean delete(int id) {
        boolean checkResult = paymentsRepository.existsById(id);
        if (checkResult) {
            paymentsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
