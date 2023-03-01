package site.weic.snow.lib.web.common.filter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * EnableWebCommonAlways
 *
 * @author Zhang Wei
 * @version EnableWebCommonAlways.java v1.0 2023-03-01
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(EnableWebCommonAlwaysDiscovery.class)
public @interface EnableWebCommonAlways {
}

@Configuration
@ComponentScan
interface EnableWebCommonAlwaysDiscovery {
}