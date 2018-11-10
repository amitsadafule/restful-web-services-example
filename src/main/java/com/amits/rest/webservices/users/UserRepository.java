package com.amits.rest.webservices.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Amit Sadafule
 *
 * 07-Nov-2018
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
