package org.craftercms.oauth

//@Grab(group='io.corbel', module='oauth-filter-api', version='1.44.0')
@Grab(group='org.pac4j', module='pac4j-oauth', version='4.0.2')
@Grab(group='org.pac4j', module='j2e-pac4j', version='4.1.0')

import org.pac4j.core.config.Config
import org.pac4j.core.context.JEEContext
import org.pac4j.core.context.session.JEESessionStore
import org.pac4j.core.context.session.SessionStore
import org.pac4j.core.engine.DefaultSecurityLogic
import org.pac4j.core.engine.SecurityLogic
import org.pac4j.core.http.adapter.HttpActionAdapter
import org.pac4j.core.http.adapter.JEEHttpActionAdapter
import org.pac4j.core.util.FindBest
import org.pac4j.core.engine.SecurityGrantedAccessAdapter
import org.pac4j.j2e.util.Pac4JHttpServletRequestWrapper

/**
 * Demonstrates OAUTH Security 
 * Wraps OAuth implementation details
 */ 
public class CrafterOAuth {
    

    /**
     * called on every request that needs to be protected
     */
    public doSecurityFilter(request, response, session, filterChain) {

        Config config = Config.INSTANCE

        String clients = "AnonymousClient"
        String authorizers = "mustBeAnon"
        String matchers = "excludedPath"
        Boolean multiProfile = false

        final SessionStore<JEEContext> bestSessionStore = FindBest.sessionStore(null, config, JEESessionStore.INSTANCE)
        final HttpActionAdapter<Object, JEEContext> bestAdapter = FindBest.httpActionAdapter(null, config, JEEHttpActionAdapter.INSTANCE)
        final SecurityLogic<Object, JEEContext> bestLogic = FindBest.securityLogic(null, config, DefaultSecurityLogic.INSTANCE)

        final JEEContext context = new JEEContext(request, response, bestSessionStore)

        def securityGrantedAccessAdapter = new SecurityGrantedAccessAdapter() {
            
            public Object adapt(org.pac4j.core.context.WebContext webContext, java.util.Collection appProfiles, Object[] parameters)
            throws Exception {
                
                filterChain.doFilter(new Pac4JHttpServletRequestWrapper(request, profiles), response)
                
                return null;
            }
        }
        
        bestLogic.perform(context, config, securityGrantedAccessAdapter, bestAdapter, clients, authorizers, matchers, multiProfile)
    }

    /**
     * called to complete the authorizaiton handshake
     */
    public doCallbackFilter(request, response, session, filterChain) {
        filterChain.doFilter(request, response)
        
    }
    
    /**
     * called to log the user out
     */
    public doLogoutFilter(request, response, session, filterChain) {
        filterChain.doFilter(request, response)            
    }
}