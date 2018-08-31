package de.hsba.test.bike.bike.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.name = :name")
    User findByName(@Param("name") String name);

    @Query("select u from User u where u.role = 'USER'")
    List<User> findUsers();
}
