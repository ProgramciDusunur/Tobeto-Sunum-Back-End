package com.tobeto.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.tobeto.entity.Employee;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenService {
	private String KEY = "5fYk1YRi8yKP8OH/fOkPxqmUWzeez/R/hb9nZLkOwtp4T80hmTJ1tD26ry0a6Kp1qwJtzmIlU5Ayh0kMxklLeA==";

	public String createToken(Employee employee) {
		JwtBuilder builder = Jwts.builder();
//		List<Roller> rollerEmployee = employee.getRollers();
//
//		String[] roller = new String[rollerEmployee.size()];
//		for (int i = 0; i < rollerEmployee.size(); i++) {
//			roller[i] = rollerEmployee.get(i).getRol();
//		}

		// add custom keys
		// rol tablosu eklenecek (buna göre token dönüyor.)
		// Projeye secret key eklenecek.
		Map<String, Object> customKeys = new HashMap<>();
		customKeys.put("roller", employee.getRole());
		builder = builder.claims(customKeys);

		Instant tarih = Instant.now().plus(60, ChronoUnit.MINUTES);

		builder = builder.subject(employee.getSurname()).id(employee.getName()).issuedAt(new Date())
				.expiration(Date.from(tarih));

		return builder.signWith(getKey()).compact();
	}

	public Claims tokenKontrol(String token) {
		JwtParser builder = Jwts.parser().verifyWith(getKey()).build();
		return builder.parseSignedClaims(token).getPayload();
	}

	private SecretKey getKey() {
		SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(KEY));
		return key;
	}

	public static void main(String[] args) {
		keyUret();
	}

	public static void keyUret() {
		SecretKey key = Jwts.SIG.HS512.key().build();
		String str = Encoders.BASE64.encode(key.getEncoded());
		System.out.println(str);
	}
}
