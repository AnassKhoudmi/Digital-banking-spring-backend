package net.khoudmi.ebankingbackend.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.khoudmi.ebankingbackend.dtos.CustomerDTO;
import net.khoudmi.ebankingbackend.exceptions.CustomerNotFoundException;
import net.khoudmi.ebankingbackend.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class CustomerRestController {
    private BankAccountService bankAccountService;

    @GetMapping("/customers")
    public List<CustomerDTO> customers(){
      return bankAccountService.listCustomers();
    }
    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomer(@PathVariable(name="id") Long costumerId) throws CustomerNotFoundException {
        return bankAccountService.getCustomer(costumerId);
    }
    @PostMapping("/customers")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) throws CustomerNotFoundException {
        return bankAccountService.saveCustomer(customerDTO);
    }
    @PutMapping("/customers/{customerId}")
    public CustomerDTO updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO customerDTO) throws CustomerNotFoundException {
        customerDTO.setId(customerId);
        return bankAccountService.updateCustomer(customerDTO);
    }
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) throws CustomerNotFoundException {
        bankAccountService.deleteCustomer(id);
    }
}
