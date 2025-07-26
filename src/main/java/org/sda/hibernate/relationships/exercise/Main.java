package org.sda.hibernate.relationships.exercise;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Account.class)
                .addAnnotatedClass(Bank.class)
                .buildSessionFactory()
                .openSession();

        Bank bank = new Bank();

        bank.setName("BKT");
        bank.setSwiftCode("NBASXCLS");



        Account account1 = new Account();
        account1.setHolder("Gledis");
        account1.setIBAN("ALL241628172CLIDCLALL0");
        account1.setBalance(new BigDecimal(100));
        account1.setBank(bank);

        Account account2 = new Account();
        account2.setHolder("Tom");
        account2.setIBAN("ALL241628172CLIDCLEUR0");
        account2.setBalance(new BigDecimal(200));
        account2.setBank(bank);

        List<Account> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);

        bank.setAccounts(accounts);

//        session.beginTransaction();
//        session.persist(bank);
//        session.getTransaction().commit();

        Bank bank1 = session.find(Bank.class, 52L);

        session.beginTransaction();
        session.remove(bank1);
        session.getTransaction().commit();
        System.out.println("Bank: " + bank.getName() + " has accounts: " + bank.getAccounts());
    }
}
