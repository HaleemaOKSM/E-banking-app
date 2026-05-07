package com.example.demo.repositories;

import com.example.demo.entities.BankAccount;
import com.example.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
    @Query("SELECT SUM(a.balance) FROM BankAccount a")
    Double sumAllBalances();

    @Query("SELECT COUNT(a) FROM CurrentAccount a")
    long countCurrentAccounts();

    @Query("SELECT COUNT(a) FROM SavingAccount a")
    long countSavingAccounts();
}
