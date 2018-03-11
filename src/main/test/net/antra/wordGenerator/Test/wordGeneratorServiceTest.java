package net.antra.wordGenerator.Test;

import net.antra.wordGenerator.config.MvcConfig;
import net.antra.wordGenerator.service.wordGeneratorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = MvcConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
public class wordGeneratorServiceTest {

    //@Before
    //@Autowired
    //wordGeneratorService ws;

    @Test
    public void letterCombinations() {
        wordGeneratorService ws = new wordGeneratorService();
       ws.letterCombinations("1234567") ;
    }

    @Test
    public void letterPage() {
    }

    @Test
    public void totalPage() {
    }
}