import org.craftercms.oauth.CrafterOAuth

def requestURI = request.getRequestURL()
def oauth = new CrafterOAuth() // for now

if("/callback".equals(requestURI)) {
    // if callback
    oauth.doCallbackFilter(request, response, session, filterChain)
}
else if("/logout".equals(requestURI)) {
    // if logout
    oauth.doLogoutFilter(request, response, session, filterChain)
}
else {
    // otherwise (filter any request passed our way)
    oauth.doSecurityFilter(request, response, session, filterChain)
}
          