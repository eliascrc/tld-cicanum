package cr.ac.ucr.cicanum.tld.ws.rest.support.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * CORS Enabled Success AuthenticationHandler. This handler will return a 200 OK HTTP Status code if a CORS
 * request is detected (by checking the existence of the Origin Header in the request). If not then a 302
 * redirect is send.
 *
 * @author Rodrigo A. Bartels
 */
@Component("successLoginHandler")
public class SuccessAuthenticationHandler extends SimpleUrlAuthenticationSuccessHandler {

    private static final transient Logger logger = LoggerFactory.getLogger(SuccessAuthenticationHandler.class);

    private RedirectStrategy redirectStrategy;

    @PostConstruct
    private void init() {
        this.redirectStrategy = new DefaultRedirectStrategy();
    }

    @Override
    @Transactional
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        this.setDefaultTargetUrl(this.determineTargetUrl(authentication));

        if (request.getHeader("Origin") != null) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            response.addHeader("Access-Control-Allow-Credentials", "true");
            response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type, Origin, Authorization");

            this.redirectStrategy.sendRedirect(request, response, this.getDefaultTargetUrl());
        } else
            super.onAuthenticationSuccess(request, response, authentication);
    }

    /**
     * Determines the url where the user should be redirected
     * @param authentication where the roles will be extracted from
     * @return the target url.
     */
    private String determineTargetUrl(Authentication authentication) {
        final String cicanumUserAuthenticated = "/ws/cicanumUser/authenticated";
        final String serviceManagerAuthenticated = "/ws/serviceManager/authenticated";
        final String ccssManagerAuthenticated = "/ws/ccssManager/authenticated";

        boolean isCicanumUser, isServiceManager, isCcssManager;
        isCicanumUser = isServiceManager = isCcssManager = false;

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        label:
        for (GrantedAuthority grantedAuthority : authorities) {
            switch (grantedAuthority.getAuthority()) {
                case "ROLE_CICANUM_USER":
                    isCicanumUser = true;
                    break label;
                case "ROLE_SERVICE_MANAGER":
                    isServiceManager = true;
                    break label;
                case "ROLE_CCSS_MANAGER":
                    isCcssManager = true;
                    break label;
            }
        }

        if (isCicanumUser) {
            return cicanumUserAuthenticated;

        } else if (isServiceManager) {
            return serviceManagerAuthenticated;

        } else if (isCcssManager) {
            return ccssManagerAuthenticated;

        } else {
            throw new IllegalArgumentException("The specified user does not have the necessary roles.");
        }
    }
}