package site.weic.snow.web.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;

/**
 * HomeController
 *
 * @author Zhang Wei
 * @version HomeController.java v1.0 2023-03-01
 */
@RestController
@RequestMapping("home")
@Slf4j
public class HomeController {

    @GetMapping("index")
    public String index(HttpServletRequest request){
        final Enumeration<String> headerNames = request.getHeaderNames();
        StringBuilder builder = new StringBuilder();
        builder.append("Hello, it is ").append(DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now())).append(" now.<br><ol>");
        while(headerNames.hasMoreElements()){
            final String header = headerNames.nextElement();
            final String headerValue = request.getHeader(header);
            builder.append("<li>").append(header).append(": ").append(headerValue).append("</li>");
            log.info("{}: {}", header, headerValue);
        }
        builder.append("</ol>");
        return builder.toString();
    }
}
