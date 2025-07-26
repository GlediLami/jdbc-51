package org.sda.hibernate.relationships.exercise;



import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "bank")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Bank entity. id, swiftCode (String), name (String), List<Account>
    private String swiftCode;

    private String name;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private List<Account> accounts;
}
