//@Grab(group='se.curity', module='oauth-filter', version='2.0.0', initClass=false)

logger.info("before")

filterChain.doFilter(request, response)

logger.info("after")