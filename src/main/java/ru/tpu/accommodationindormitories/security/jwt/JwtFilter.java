package ru.tpu.accommodationindormitories.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.tpu.accommodationindormitories.security.CustomUserDetails;
import ru.tpu.accommodationindormitories.security.CustomUserServiceImpl;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final CustomUserServiceImpl customUserService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {

        String path = request.getServletPath();

        if (path.startsWith("/api/v1/auth/") || path.equals("/api/v1/users/new-user")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = getTokenFromRequest(request);
        if (token != null && jwtService.booleanValidateJwtToken(token)) {
            setCustomUserDetailsToSecurityContextHolder(token);
        }

        filterChain.doFilter(request, response);
    }

    private void setCustomUserDetailsToSecurityContextHolder(String token) {
        String username = jwtService.getUsernameFromToken(token);
        CustomUserDetails customUserDetails = customUserService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                customUserDetails, null, customUserDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    private String getTokenFromRequest(HttpServletRequest httpServletRequest) {
        String bearerToken = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}