package ua.nure.mediaserver.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import ua.nure.mediaserver.domain.User;

import java.util.List;


@Repository
public class UserRepositoryImpl implements UserRepository{


    @Autowired
    private MongoTemplate mongoTemplate;

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void create(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public User readByEmail(String email) {
        return mongoTemplate.findOne(new Query(Criteria.where("email").is(email)), User.class);
    }

    @Override
    public User readByPassword(String password) {
        return mongoTemplate.findOne(new Query(Criteria.where("password").is(password)), User.class);
    }

    @Override
    public List<User> readAll() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User update(User user) {
        return mongoTemplate.findAndModify(new Query(Criteria.where("email").is(user.getEmail())),
                new Update().set("name", user.getName()).set("surname", user.getSurname()),
                new FindAndModifyOptions().returnNew(true),
                User.class);
    }

    @Override
    public void delete(String email) {
        mongoTemplate.findAndRemove(new Query(Criteria.where("email").is(email)), User.class);
    }
}
