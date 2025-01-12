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

    public PaymentsResDTO save(PaymentsResDTO paymentsResDTO) {
        Payments payments = PaymentsMapper.INSTANCE.toEntity(paymentsResDTO);
        Payments savePayments = paymentsRepository.save(payments);
        return PaymentsMapper.INSTANCE.toDTO(savePayments);
    }

    public Payments update(Payments payments) {
        return paymentsRepository.save(payments);
    }

    public List<PaymentsResDTO> getAllPayments() {
        return paymentsRepository.findAll()
                .stream()
                .map(PaymentsMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public Payments findById(int id) {
        return paymentsRepository.findById(id).orElse(null);
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
