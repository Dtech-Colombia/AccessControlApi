package co.com.dtech.accesscontrol.security.jwt;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.apache.commons.text.StringTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import co.com.dtech.accesscontrol.entities.User;
import co.com.dtech.accesscontrol.security.model.UserBean;
import co.com.dtech.accesscontrol.security.model.UserTypeBean;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;

@Component
public class JwtTokenUtil implements Serializable {

	static final String CLAIM_KEY_USERNAME = "sub";
	static final String CLAIM_KEY_CREATED = "iat";
	private static final long serialVersionUID = -3301605591108950415L;
	private Clock clock = DefaultClock.INSTANCE;

	@Value("${jwt.signing.key.secret}")
	private String secret;

	@Value("${jwt.token.expiration.in.seconds}")
	private Long expiration;

	public UserBean getUserFromToken(String token) {
		UserBean user = new UserBean();
		String subject = getClaimFromToken(token, Claims::getSubject);
		StringTokenizer str = new StringTokenizer(subject, "|");
		str.setEmptyTokenAsNull(false);
		str.setIgnoreEmptyTokens(false);
		user.setId(Integer.parseInt(str.nextToken()));
		user.setNames(str.nextToken());
		user.setLastName1(str.nextToken());
		user.setLastName2(str.nextToken());
		user.setUsername(str.nextToken());
		user.setUserType(new UserTypeBean(Integer.parseInt(str.nextToken()), str.nextToken()));
		return user;
	}

	public Date getIssuedAtDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getIssuedAt);
	}

	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	public Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(clock.now());
	}

	public String doGenerateToken(User user) {
		final Date createdDate = clock.now();
		final Date expirationDate = calculateExpirationDate(createdDate);

		return Jwts.builder().setSubject(getSubjectFromUser(user)).setIssuedAt(createdDate)
				.setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	private String getSubjectFromUser(User user) {
		StringBuilder sb = new StringBuilder();
		sb.append(user.getId()).append("|")
			.append(user.getNames()).append("|")
			.append(user.getLastName1()).append("|")
			.append(user.getLastName2()).append("|")
			.append(user.getUsername()).append("|")
			.append(user.getUserType().getId()).append("|")
			.append(user.getUserType().getDescription());
		return sb.toString();
	}

	public Boolean canTokenBeRefreshed(String token) {
		return (!isTokenExpired(token));
	}

	public String refreshToken(String token) {
		final Date createdDate = clock.now();
		final Date expirationDate = calculateExpirationDate(createdDate);

		final Claims claims = getAllClaimsFromToken(token);
		claims.setIssuedAt(createdDate);
		claims.setExpiration(expirationDate);

		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	private Date calculateExpirationDate(Date createdDate) {
		return new Date(createdDate.getTime() + expiration * 1000);
	}
}
