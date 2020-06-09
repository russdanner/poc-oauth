import org.craftercms.oauth.CrafterOAuth


logger.info("before")

filterChain.doFilter(request, response)

logger.info("after")