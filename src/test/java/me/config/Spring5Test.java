package me.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ExtendWith(SpringExtension.class)
@ContextConfiguration({"classpath:/spring/root-context.xml",
    "classpath:/spring/context-datasource.xml",
    "classpath:/spring/context-mybatis.xml",
    "classpath:/spring/dispatcherServlet.xml"})
public @interface Spring5Test {
}
