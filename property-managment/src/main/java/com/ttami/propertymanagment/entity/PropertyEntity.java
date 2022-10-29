package com.ttami.propertymanagment.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="PROPERTY_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name="PROPERTY_TITEL",nullable = false)
    private String title;
    private String description;
    private String ownerName;
    @Column(name = "EMAIL",nullable = false)
    private String ownerEmail;
    private Double proce;
    private String address;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID",nullable = false)
    private UserEntity userEntity;



}
