@Grab(group='io.corbel.lib', module='config', version='0.4.0')
@Grab(group='io.corbel', module='oauth-filter-api', version='1.44.0')

// import io.corbel.lib.token.TokenGrant
// import io.corbel.lib.token.TokenInfo
// import io.corbel.lib.token.factory.TokenFactory
// import io.corbel.lib.token.model.TokenType
// import io.corbel.lib.token.parser.TokenParser
// import io.corbel.lib.token.provider.SessionProvider
import io.corbel.oauth.filter.FilterRegistry
import io.corbel.oauth.filter.exception.AuthFilterException
import io.corbel.oauth.model.Client
import io.corbel.oauth.model.User
import io.corbel.oauth.service.ClientService
import io.corbel.oauth.service.UserService
import io.corbel.oauth.session.SessionBuilder
import io.corbel.oauth.session.SessionCookieFactory
import io.corbel.oauth.token.TokenExpireTime



logger.info("before")

filterChain.doFilter(request, response)

logger.info("after")