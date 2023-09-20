# Spring boot authorization server with Josh Long

- spring boot 3.1.3
- maven


Inspiration: 
https://www.youtube.com/watch?v=7zm3mxaAFWk&ab_channel=Coffee%2BSoftwarewithJoshLong

Util resources:
https://spring.io/blog/2023/05/24/spring-authorization-server-is-on-spring-initializr

## Get info about openid discovery endpoints

http://localhost:8080/.well-known/openid-configuration

## Getting an Access Token
```
http -f POST :8080/oauth2/token grant_type=client_credentials scope='user.read' -a client:secret
```

## Introspecting an Access Token
```
TOKEN=$(http -f POST :8080/oauth2/token grant_type=client_credentials scope='user.read' -a client:secret | jq -r .access_token)
http -f POST :8080/oauth2/introspect token=$TOKEN -a admin-client:secret
```


## Invoke resource server
```
TOKEN=$(http -f POST :8080/oauth2/token grant_type=client_credentials scope='user.read' -a client:secret | jq -r .access_token)
curl -H"Authorization: bearer $TOKEN" http://localhost:8081/hello
```


## Login

http://127.0.0.1:8082/
login with username "user" and password from generated security password printed in console
or use users from InMemoryUserDetailsManager(gandra, admin)

