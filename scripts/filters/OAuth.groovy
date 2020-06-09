import org.craftercms.oauth.CrafterOAuth

def requestURI = request.getRequestURL()

if("/callback".equals(requestURI)) {
    // if callback
    CrafterOAuth.doCallbackFilter(request, response, session, filterChain)
}
else if("/logout".equals(requestURI)) {
    // if logout
    CrafterOAuth.doLogoutFilter(request, response, session, filterChain)
}
else {
    // otherwise (filter any request passed our way)
    CrafterOAuth.doSecurityFilter(request, response, session, filterChain)
}
        
