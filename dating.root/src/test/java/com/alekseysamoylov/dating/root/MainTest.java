package com.alekseysamoylov.dating.root;

import com.alekseysamoylov.dating.root.config.RootConfiguration;
import com.alekseysamoylov.dating.root.service.MainService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by alekseysamoylov on 5/13/17.
 */
@RunWith(SpringRunner.class)
@Import(RootConfiguration.class)
public class MainTest {

    @Autowired
    private MainService mainService;

    @Test
    public void helloTest() {
        System.out.println(mainService.helloService());
    }
}
