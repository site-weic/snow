package site.weic.snow.lib.web.common.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import site.weic.snow.lib.base.util.constant.WebConstant;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

/**
 * MsgIdFilter
 *
 * @author Zhang Wei
 * @version MsgIdFilter.java v1.0 2023-03-01
 */
@Slf4j
@Component
public class MsgIdFilter implements Filter {

    /** {@inheritDoc} */
    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        final long start = System.nanoTime();
        final String uri = httpServletRequest.getRequestURI();
        String msgId = httpServletRequest.getHeader(WebConstant.MSG_ID_NAME);
        if (msgId == null) {
            msgId = UUID.randomUUID().toString();
        }
        MDC.put("MSG_ID", msgId);
        try {
            chain.doFilter(request, response);
        } finally {
            final long end = System.nanoTime();
            log.info("{}ms {}", (end - start) / 1000_1000L, uri);
        }
    }
}
