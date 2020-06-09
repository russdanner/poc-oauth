@Grab(group='org.pac4j', module='pac4j-oauth', version='4.0.2')

//import org.craftercms.oauth.CrafterOAuth
import org.pac4j.core.util.FindBest

logger.info("before")

filterChain.doFilter(request, response)

logger.info("after")