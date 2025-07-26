package org.sda.hibernate.relationships.exercise;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String holder;

    private String IBAN;

    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

}
