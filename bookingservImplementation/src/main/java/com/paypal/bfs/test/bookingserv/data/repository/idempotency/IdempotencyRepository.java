package com.paypal.bfs.test.bookingserv.data.repository.idempotency;

import com.paypal.bfs.test.bookingserv.data.model.idempotency.IdempotencyEntity;
import org.springframework.data.repository.CrudRepository;

public interface IdempotencyRepository extends CrudRepository<IdempotencyEntity, String> {
}
