package org.craftercms.oauth

//@Grab(group='io.corbel', module='oauth-filter-api', version='1.44.0')
@Grab(group='org.pac4j', module='pac4j-oauth', version='4.0.2')

public class CrafterOAuth {
    
    public doSecurityFilter(request, response, session) {
       // final Config config = getSharedConfig();

       // final SessionStore<JEEContext> bestSessionStore = FindBest.sessionStore(null, config, JEESessionStore.INSTANCE);
        final HttpActionAdapter<Object, JEEContext> bestAdapter = FindBest.httpActionAdapter(null, config, JEEHttpActionAdapter.INSTANCE);
        final SecurityLogic<Object, JEEContext> bestLogic = FindBest.securityLogic(securityLogic, config, DefaultSecurityLogic.INSTANCE);

        final JEEContext context = new JEEContext(request, response, bestSessionStore);
        bestLogic.perform(context, config, (ctx, profiles, parameters) -> {
            // if no profiles are loaded, pac4j is not concerned with this request
            filterChain.doFilter(profiles.isEmpty() ? request : new Pac4JHttpServletRequestWrapper(request, profiles), response);
            return null;
        }, bestAdapter, clients, authorizers, matchers, multiProfile);
    }
    }
}