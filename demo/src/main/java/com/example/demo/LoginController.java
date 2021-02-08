package com.example.demo;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import javax.servlet.annotation.HttpConstraint;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import javax.xml.bind.DatatypeConverter;

import org.apache.tomcat.jni.Local;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
//import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties.Storage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HttpServletBean;

import com.google.gwt.http.client.URL;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LoginController {
String token_export =""; 
	@Autowired 
 
private LoginRepo lr;

	
	@GetMapping("/allUsers")
	public Iterable<LoginEntity> Users()
	{
		return lr.findAll();
	}
	
	@GetMapping("/token")
	public String get_Token(@RequestParam String username,@RequestParam String password)
	{
		
		String jws = Jwts.builder()
		  
		  .claim("name", username)
		  .claim("password", password)
		  // Fri Jun 24 2016 15:33:42 GMT-0400 (EDT)
		  .setIssuedAt(Date.from(Instant.ofEpochSecond(1466796822L)))
		  // Sat Jun 24 2116 15:33:42 GMT-0400 (EDT)
		  .setExpiration(Date.from(Instant.ofEpochSecond(4622470422L)))
		  .signWith(
		    SignatureAlgorithm.HS256,
		    "My Secret Key"
		  )
		  .compact();
		

	

		return jws;
	}
	
	
	@GetMapping("/verifytoken")
	public String get_Headers(HttpServletRequest req)
	{
		
		
	
		String jws = req.getHeader("Authorized");
		
		
		try {
			Claims claims = Jwts.parser()
		            .setSigningKey(DatatypeConverter.parseBase64Binary("My Secret Key"))
		            .parseClaimsJws(jws).getBody();
			
			
			JSONObject jobj =new  JSONObject(claims);
			
//			System.out.println((String)jobj.get("name"));
		return 	"true";
		} catch (Exception e) {
//			System.out.println("Error");
			return "Error";
		}
		
	
		
		
		
	
	}
	
//	@GetMapping("/verifytoken")
//	public String VerifyToken(@RequestParam String jws) {
//		
//		try {
//			Claims claims = Jwts.parser()
//		            .setSigningKey(DatatypeConverter.parseBase64Binary("My Secret Key"))
//		            .parseClaimsJws(jws).getBody();
//			
//			
//			JSONObject jobj =new  JSONObject(claims);
//			
////			System.out.println((String)jobj.get("name"));
//		return 	jobj.toString();
//		} catch (Exception e) {
////			System.out.println("Error");
//			return "Error";
//		}
//		
//	
//	}
//	
	@PostMapping("/login")
	public LoginEntity login(HttpServletResponse res,@RequestBody LoginEntity username)
	{
		
	
		if(lr.findUserByStatusNative(username.getUsername()) != null) {
	
		
	
		return lr.findUserByStatusNative(username.getUsername());
	
	}
		
	
		else {
			LoginEntity	sonuc =new LoginEntity();
			
			return sonuc;
	}}
	
	
	@PostMapping("/save")
	public LoginEntity save(@RequestBody LoginEntity e)
	{
		System.out.println(e);
		return lr.save(e);
//		return e;
	}

	@PostMapping("/removeuser")
	public LoginEntity removeUser(@RequestBody LoginEntity e)
	{
		System.out.println(e);
		lr.deleteById(e.getId());
		return e;
	}
}
