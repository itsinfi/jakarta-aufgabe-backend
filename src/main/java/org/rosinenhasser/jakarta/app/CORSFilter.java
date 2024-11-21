import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/*")
public class CORSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (response instanceof HttpServletResponse) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;

            // Set CORS headers
            httpResponse.setHeader("Access-Control-Allow-Origin", "*"); // Allow all origins
            httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // Allowed methods
            httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, Authorization"); // Allowed headers
            httpResponse.setHeader("Access-Control-Expose-Headers", "Authorization, Link"); // Exposed headers
            httpResponse.setHeader("Access-Control-Allow-Credentials", "true"); // If credentials are allowed
            httpResponse.setHeader("Access-Control-Max-Age", "3600"); // Preflight cache duration

            // Handle preflight requests
            if ("OPTIONS".equalsIgnoreCase(((HttpServletRequest) request).getMethod())) {
                httpResponse.setStatus(HttpServletResponse.SC_OK);
                return; // Do not pass to next filter
            }
        }

        // Proceed with the next filter or servlet
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code if needed
    }
}
