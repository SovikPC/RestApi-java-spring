//package ru.gurov.api.Models;
//
//import jakarta.persistence.*;
//import org.hibernate.annotations.GenericGenerator;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@Entity
//@Table(name = "Roles")
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class Roles {
//
//    @Id
//    @Column(name = "id_role")
//    @GenericGenerator(name = "generator", strategy = "increment")
//    @GeneratedValue(generator = "generator")
//    private Long id_role;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "name_role")
//    private ERoles name;
//
//}
