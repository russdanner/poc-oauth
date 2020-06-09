package org.craftercms.oauth

//@Grab(group='io.corbel', module='oauth-filter-api', version='1.44.0')
@Grab(group='org.pac4j', module='pac4j-oauth', version='4.0.2')

import org.pac4j.core.config.Config
import org.pac4j.core.context.JEEContext
import org.pac4j.core.context.session.JEESessionStore
import org.pac4j.core.context.session.SessionStore
import org.pac4j.core.engine.DefaultSecurityLogic
import org.pac4j.core.engine.SecurityLogic
import org.pac4j.core.http.adapter.HttpActionAdapter
import org.pac4j.core.http.adapter.JEEHttpActionAdapter
import org.pac4j.core.util.FindBest

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

        String clients = ""
        String authorizers = ""
        String matchers = ""
        Boolean multiProfile = false


        final SessionStore<JEEContext> bestSessionStore = FindBest.sessionStore(null, config, JEESessionStore.INSTANCE);
        final HttpActionAdapter<Object, JEEContext> bestAdapter = FindBest.httpActionAdapter(null, config, JEEHttpActionAdapter.INSTANCE);
        final SecurityLogic<Object, JEEContext> bestLogic = FindBest.securityLogic(null, config, DefaultSecurityLogic.INSTANCE);
        
        // wrap the request so it's pac4j aware
        //new Pac4JHttpServletRequestWrapper(request, profiles)
        
        
        filterChain.doFilter(request, response)
        
        

//     FacebookClient facebookClient = new FacebookClient(FB_KEY, FB_SECRET);
// TwitterClient twitterClient = new TwitterClient(TW_KEY, TW_SECRET);
// FormClient formClient = new FormClient("http://localhost:8080/theForm.jsp", new SimpleTestUsernamePasswordAuthenticator(), new UsernameProfileCreator());
// CasClient casClient = new CasClient();
// casClient.setCasLoginUrl("http://mycasserver/login");
// Clients clients = new Clients("http://localhost:8080/callback", facebookClient, twitterClient, formClient, casClient);
// Config config = new Config(clients);
// config.addAuthorizer("admin", new RequireAnyRoleAuthorizer("ROLE_ADMIN"));

        
       // final Config config = getSharedConfig();

       // final SessionStore<JEEContext> bestSessionStore = FindBest.sessionStore(null, config, JEESessionStore.INSTANCE);
        // final HttpActionAdapter<Object, JEEContext> bestAdapter = FindBest.httpActionAdapter(null, config, JEEHttpActionAdapter.INSTANCE);
        // final SecurityLogic<Object, JEEContext> bestLogic = FindBest.securityLogic(securityLogic, config, DefaultSecurityLogic.INSTANCE);

        // final JEEContext context = new JEEContext(request, response, bestSessionStore);
        // bestLogic.perform(context, config, (ctx, profiles, parameters) -> {
        //     // if no profiles are loaded, pac4j is not concerned with this request
        //     filterChain.doFilter(profiles.isEmpty() ? request : , response);
        //     return null;
        // }, bestAdapter, clients, authorizers, matchers, multiProfile);
//    }
    
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