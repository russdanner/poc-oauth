// https://mvnrepository.com/artifact/se.curity/oauth-filter
@Grapes(
    @Grab(group='se.curity', module='oauth-filter', version='2.0.0')
)


logger.info("before")

filterChain.doFilter(request, response)

logger.info("after")