package com.example.projectShopOnline.services;

import com.example.projectShopOnline.entities.Payments;
import com.example.projectShopOnline.repository.PaymentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentsService {
    private final PaymentsRepository paymentsRepository;

    public PaymentsService(PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }

    public Payments save(Payments payments) {
        return paymentsRepository.save(payments);
    }

    public Payments update(Payments payments) {
        return paymentsRepository.save(payments);
    }

    public List<Payments> findAll() {
        return paymentsRepository.findAll();
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
