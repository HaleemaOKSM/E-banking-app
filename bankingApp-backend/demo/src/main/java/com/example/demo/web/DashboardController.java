package com.example.demo.web;

import com.example.demo.entities.AccountOperation;
import com.example.demo.entities.BankAccount;
import com.example.demo.entities.CurrentAccount;
import com.example.demo.entities.SavingAccount;
import com.example.demo.enums.OperationType;
import com.example.demo.repositories.AccountOperationRepository;
import com.example.demo.repositories.BankAccountRepository;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final CustomerRepository customerRepository;
    private final BankAccountRepository accountRepository;
    private final AccountOperationRepository operationRepository;

    public DashboardController(CustomerRepository customerRepository,
                               BankAccountRepository accountRepository,
                               AccountOperationRepository operationRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
        this.operationRepository = operationRepository;
    }

    @GetMapping("/stats")
    public Map<String, Object> getStats() {
        List<BankAccount> accounts = accountRepository.findAll();
        List<AccountOperation> operations = operationRepository.findAll();

        double totalBalance = accounts.stream()
                .mapToDouble(BankAccount::getBalance)
                .sum();

        double totalCredits = operations.stream()
                .filter(o -> o.getType() == OperationType.CREDIT)
                .mapToDouble(AccountOperation::getAmount)
                .sum();

        double totalDebits = operations.stream()
                .filter(o -> o.getType() == OperationType.DEBIT)
                .mapToDouble(AccountOperation::getAmount)
                .sum();

        long totalCurrentAccounts = accounts.stream()
                .filter(a -> a instanceof CurrentAccount)
                .count();

        long totalSavingAccounts = accounts.stream()
                .filter(a -> a instanceof SavingAccount)
                .count();

        return Map.of(
                "totalCustomers",       customerRepository.count(),
                "totalAccounts",        accounts.size(),
                "totalOperations",      operations.size(),
                "totalBalance",         totalBalance,
                "totalCredits",         totalCredits,
                "totalDebits",          totalDebits,
                "totalCurrentAccounts", totalCurrentAccounts,
                "totalSavingAccounts",  totalSavingAccounts
        );
    }
}
