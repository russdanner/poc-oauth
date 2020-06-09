@Grab(group='org.pac4j', module='pac4j-oauth', version='4.0.2')


logger.info("before")

filterChain.doFilter(request, response)

logger.info("after")