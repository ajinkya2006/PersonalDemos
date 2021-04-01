package spring.repository;

import org.springframework.data.repository.CrudRepository;

import spring.entities.Account;

public interface AccountRepository extends CrudRepository<Account, Long>{

}
