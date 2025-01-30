package com.example.Ecommerce.service;

//
//@Service
//public class CustomerService {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//
//    public void addCustomer(String Name, String email ,String phone) {
//            Customer customer = new Customer();
////            if(isEmailExist(email)){
////                throw new EmailAlreadyExistException(email);
////            }
//            customer.setName(Name);
//            customer.setPhone(phone);
//            customer.setEmail(email);
//            customerRepository.save(customer);
//    }
//
////    public Customer getByEmail(String email) {
////        return customerRepository.findByEmail(email)
////                .orElseThrow(() -> new EmailNotFoundException(email));
////    }
//
////    public boolean isEmailExist(String email) {
////        return customerRepository.findByEmail(email).isPresent();
////    }
//
//    public List<Customer> getAllCustomer() {
//        return customerRepository.findAll();
//    }
//
//    public Customer getCustomerById(Long id) {
//        return customerRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Customer not found"));
//    }
//
//    public void updateCustomer(Long id, String Name, String email, String phone) {
//        Customer customer = customerRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Customer not found"));
//        customer.setName(Name);
//        customer.setPhone(phone);
//        customer.setEmail(email);
//        customerRepository.save(customer);
//    }
//
//    public void deleteCustomer(Long id) {
//        customerRepository.deleteById(id);
//    }
////    public void deleteCustomer(String firstName){
//////        if (!customerRepository.existsByFirstName(firstName)) {
//////            throw new EntityNotFoundException("No record found with first name: " + firstName);
//////        }
////        customerRepository.deleteByFirstName(firstName);
////    }
////
////    public List<Customer> getByFirstName(String firstName) {
////        return customerRepository.findByFirstName(firstName);
////    }
//}


import com.example.Ecommerce.configuration.JwtTokenProvider;
import com.example.Ecommerce.configuration.LoginRequest;
import com.example.Ecommerce.dto.CustomerDto;
import com.example.Ecommerce.model.Customer;
import com.example.Ecommerce.repoitory.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements UserDetailsService {

    private final CustomerRepository customerRepository;
    private  ObjectMapper objectMapper ;
    private  JwtTokenProvider jwtTokenProvider;
    public CustomerService(CustomerRepository customerRepository ,ObjectMapper objectMapper,JwtTokenProvider jwtTokenProvider) {
        this.customerRepository = customerRepository;
        this.objectMapper = objectMapper;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }
    public void register(CustomerDto customer) {
        Customer customer1 = objectMapper.convertValue(customer,Customer.class);
        Optional<Customer> existingCustomer = customerRepository.findByEmail(customer1.getEmail());
        if (existingCustomer.isPresent()) {
            throw new RuntimeException("A user with this email already exists.");
        }

         customerRepository.save(customer1);
    }
    public String login(LoginRequest request){
      Optional<Customer> customer = customerRepository.findByEmail(request.getEmail());
      if(customer.isPresent()){
         String password = customer.orElse(null).getPassword();
        if(password.equals(request.getPassword()))
        {
         return  jwtTokenProvider.generateToken(request);
        }
      }
      throw new  RuntimeException("login failed");
    }
    @Override
    public Customer loadUserByUsername(String email) throws UsernameNotFoundException {
        return customerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}