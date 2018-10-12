package com.cjx913.es;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/*使用spring的单元测试，加载spring配置文件*/
//@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:config/spring-config.xml",
        "classpath:config/spring-service.xml", "classpath:config/spring-dao.xml",
        "classpath:config/spring-activemq.xml"})
@RunWith(SpringRunner.class)
public class SpringTest {
}
