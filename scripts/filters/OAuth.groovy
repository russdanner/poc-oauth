@Grab(group='org.pac4j', module='j2e-pac4j', version='4.0.2')

logger.info("before")

filterChain.doFilter(request, response)

logger.info("after")