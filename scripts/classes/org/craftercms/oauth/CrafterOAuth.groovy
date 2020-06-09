package org.craftercms.oauth

//@Grab(group='io.corbel', module='oauth-filter-api', version='1.44.0')
@Grab(group='org.pac4j', module='pac4j-oauth', version='4.0.2')

public class CrafterOAuth {
    
    public doSecurityFilter(request, response, session, filterChain) {
        
    /*    
        // wrap the request so it's pac4j aware
        //new Pac4JHttpServletRequestWrapper(request, profiles)
        
        
       // final Config config = getSharedConfig();

       // final SessionStore<JEEContext> bestSessionStore = FindBest.sessionStore(null, config, JEESessionStore.INSTANCE);
        final HttpActionAdapter<Object, JEEContext> bestAdapter = FindBest.httpActionAdapter(null, config, JEEHttpActionAdapter.INSTANCE);
        final SecurityLogic<Object, JEEContext> bestLogic = FindBest.securityLogic(securityLogic, config, DefaultSecurityLogic.INSTANCE);

        final JEEContext context = new JEEContext(request, response, bestSessionStore);
        bestLogic.perform(context, config, (ctx, profiles, parameters) -> {
            // if no profiles are loaded, pac4j is not concerned with this request
            filterChain.doFilter(profiles.isEmpty() ? request : , response);
            return null;
        }, bestAdapter, clients, authorizers, matchers, multiProfile);
    }
    */
    
    }
    
    public doCallbackFilter(request, response, session, filterChain) {
        
    }
    
    public doLogoutFilter(request, response, session, filterChain) {
        
    }
}