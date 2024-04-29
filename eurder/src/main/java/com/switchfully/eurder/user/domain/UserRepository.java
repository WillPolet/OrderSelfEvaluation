//package com.switchfully.eurder.user.domain;
//
//import com.switchfully.eurder.user.domain.attributes.Address;
//import com.switchfully.eurder.user.domain.attributes.Role;
//import org.springframework.stereotype.Repository;
//
//import java.util.Map;
//import java.util.Optional;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Repository
//public class UserRepository {
//    private Map<String, Customer> users;
//
//    public UserRepository() {
//        this.users = new ConcurrentHashMap<>();
//        Admin admin = new Admin("admin", "root", "root@root.com", "root");
//        users.put(admin.getId(), admin);
//    }
//
//    public Optional<Customer> getUserByEmail(String email) {
//        return users.values().stream()
//                .filter(member -> member.getEmail().equals(email))
//                .findFirst();
//    }
//
//    public boolean emailExist(String email) {
//        return users.values().stream()
//                .anyMatch(member -> member.getEmail().equals(email));
//    }
//
//    public void saveUser(Customer customer) {
//        users.put(customer.getId(), customer);
//    }
//}
