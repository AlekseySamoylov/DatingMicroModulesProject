package com.alekseysamoylov.dating.root.service.impl;

import com.alekseysamoylov.dating.root.service.MainService;
import org.springframework.stereotype.Service;

/**
 * Created by alekseysamoylov on 5/13/17.
 */
@Service
public class MainServiceImpl implements MainService {

    @Override
    public String helloService() {
        return "Hello world!!!";
    }
}
