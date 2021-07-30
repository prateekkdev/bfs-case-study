package com.paypal.bfs.test.bookingserv.data.model.idempotency;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IdempotencyKeys")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdempotencyEntity {

    @Id
    private String idempotencyKey;
}