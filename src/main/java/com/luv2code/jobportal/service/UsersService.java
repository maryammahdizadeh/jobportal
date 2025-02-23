package com.luv2code.jobportal.service;

import com.luv2code.jobportal.entity.Users;
import com.luv2code.jobportal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users addNew(Users user) {
        user.setActive(true);
        user.setRegistrationDate(new Date(System.currentTimeMillis()));
        return usersRepository.save(user);
    }

    public Optional<Users> getByUserEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}
