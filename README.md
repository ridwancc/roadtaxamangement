

# Road Tax Management API

This application is written in Spring Boot and uses Keycloak to authenticate requests. 

## How to run

Navigate to project root 

```bash
docker-compose build --no-cache
docker-compose up
```

Open a new terminal window
```bash
docker run -p 8180:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin quay.io/keycloak/keycloak:13.0.0
```

Navigate to "http://localhost:8180/auth/admin/master/console/#/realms/master/partial-import"

Username: admin

Password: admin

Click on Select file and import realm-export.json from the root directory

