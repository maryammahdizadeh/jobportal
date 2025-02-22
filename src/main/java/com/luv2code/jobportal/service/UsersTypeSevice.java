package com.luv2code.jobportal.service;

import com.luv2code.jobportal.entity.UsersType;
import com.luv2code.jobportal.repository.UsersTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersTypeSevice {

    private final UsersTypeRepository usersTypeRepository;

    @Autowired
    public UsersTypeSevice(UsersTypeRepository usersTypeRepository) {
        this.usersTypeRepository = usersTypeRepository;
    }

    public List<UsersType> getAll(){
        return usersTypeRepository.findAll();
    }
}
