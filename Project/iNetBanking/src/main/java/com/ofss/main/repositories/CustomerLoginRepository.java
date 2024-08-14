package com.ofss.main.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ofss.main.domain.Login;

@Repository
public interface CustomerLoginRepository extends CrudRepository<Login, Integer> {
	Login findByloginIdAndPassword(int loginId,String password);
    Login findByloginId(int loginId);
//    Login findByCustomerId(int customerId);
//    void incrementLoginAttemptsByLoginId(int loginId);
}
