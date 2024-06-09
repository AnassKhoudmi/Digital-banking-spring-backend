package net.khoudmi.ebankingbackend.repositories;

import net.khoudmi.ebankingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
