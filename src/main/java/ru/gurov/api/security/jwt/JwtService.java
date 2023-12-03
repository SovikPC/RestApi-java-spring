package ru.gurov.api.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY="a12+4XkTK1oyWGbKnMS1Qm74eYCtu5IRvLfBhXhll9Tr4T8E188NEl18h7TFmcIUlrxbKvsZJJKn4DLMmYVocI2kTTbj8Q3zMw/N2dCd+1TbzWnD2tFgjASRHqyDKckIFTVjtTZk4F8w1VAXURDvRuny8M7UnSb1g56oZUBDIsRZs7DsDbcX579o4HfVw3SqvwnNYInbHKs/zMPCdn3kwmGpOLKxm6hSyk0Tf9hnbgUgBkJHxXiiZIyqsPNiPbCenZv9PueBPzVJ/jjCPz8R8Esypgt7cmAlqIF2n/SK80ciqNXE9RgCdFjhuWyIS/okl6pGkoTzlNfTGtKC/M99tToAxc2zrD7E0Uy9yIb5Yt0=";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ){
            return Jwts.builder()
                    .setClaims(extraClaims)
                    .setSubject(userDetails.getUsername())
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                    .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                    .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()))&& !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
