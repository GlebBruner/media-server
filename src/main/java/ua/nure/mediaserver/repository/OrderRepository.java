package ua.nure.mediaserver.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.nure.mediaserver.domain.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, ObjectId> {

}
