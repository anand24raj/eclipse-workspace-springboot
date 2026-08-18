package com.nt.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PANCARD")
public class PanCard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pan_seq")
    @SequenceGenerator(name = "pan_seq", sequenceName = "PAN_SEQ", initialValue = 101,allocationSize = 1)
    @Column(name = "PAN_ID")
    private Long panId;

    @NonNull
    @Column(length = 15)
    private String panNumber;

    @NonNull
    @Column(length = 20)
    private String issueDate;

    @OneToOne(cascade =CascadeType.ALL )
    @JoinColumn(name = "CUST_ID", unique = true)
    private Customer customer;

    public PanCard(String panNumber, String issueDate) 
    {
        this.panNumber = panNumber;
        this.issueDate = issueDate;
    }
}