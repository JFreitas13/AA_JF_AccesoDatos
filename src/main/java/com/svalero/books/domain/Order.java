package com.svalero.books.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "order_date")
    @NotBlank(message = "El campo no puede estar en blanco") //obligatorio
    @NotNull(message = "El campo no puede estar vacío")
    @DateTimeFormat
    private LocalTime orderDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userOder;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Order bookOrder;
}
