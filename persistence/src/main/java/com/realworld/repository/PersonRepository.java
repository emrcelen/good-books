package com.realworld.repository;

import com.realworld.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository< Person, Long > {

    List<Person> getByName(String name);

    /*
    @Query (name = "findByBookingLikeName", value = "SELECT p FROM Person p WHERE p.NAME LIKE %:NAME%")
    public List<Person> findPersonLikeName(@Param ("NAME")String name);
    */
}
