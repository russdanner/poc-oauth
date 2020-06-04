
System.out.println("BEFORE!")
logger.info("before")

filterChain.doFilter(request, response)

logger.info("after")