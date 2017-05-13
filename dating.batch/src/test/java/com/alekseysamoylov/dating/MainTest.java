package com.alekseysamoylov.dating;

import com.alekseysamoylov.dating.batch.config.BatchConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by alekseysamoylov on 5/13/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(BatchConfiguration.class)
public class MainTest {


    @Test
    public void test() {

    }

}
