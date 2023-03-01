package site.weic.snow.web.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import site.weic.snow.lib.web.common.filter.EnableWebCommonAlways;

/**
 * SnowUserApplication
 *
 * @author Zhang Wei
 * @version SnowUserApplication.java v1.0 2023-03-01
 */
@EnableWebCommonAlways
@SpringBootApplication
public class SnowUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnowUserApplication.class, args);
    }
}
