# FutApp Web — Spring Boot + Thymeleaf + Oracle Autonomous Database

## Pasos para correr en NetBeans

### 1. Colocar el wallet
Descomprime el Wallet_Futapp que viene en la carpeta raíz del proyecto a:
```
C:/Wallet_Futapp/
```
(O en otra ruta, pero actualiza el application.properties)

### 2. Configurar application.properties
Edita `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:oracle:thin:@futapp_high?TNS_ADMIN=C:/Wallet_Futapp
spring.datasource.username=2021073@est.cedesdonbosco.ed.cr
spring.datasource.password=TU_PASSWORD_REAL
```

### 3. Abrir en NetBeans
- File → Open Project → selecciona la carpeta `futappweb`
- NetBeans detecta automáticamente el proyecto Maven

### 4. Correr
- Clic derecho en el proyecto → Run
- O desde terminal: `mvn spring-boot:run`
- Abre: http://localhost:8080

## Módulos disponibles
| Ruta | Descripción |
|------|-------------|
| / | Página de inicio |
| /federaciones | CRUD de Federaciones |
| /equipos | CRUD de Equipos |
| /campeonatos | CRUD de Campeonatos |
| /jugadores | CRUD de Jugadores |
| /entrenadores | CRUD de Entrenadores |
| /arbitros | CRUD de Árbitros |
| /partidos | CRUD de Partidos |

## Estructura del proyecto
```
futappweb/
├── pom.xml
├── Wallet_Futapp/          ← wallet Oracle (copiar a C:/Wallet_Futapp)
├── README.md
└── src/main/
    ├── java/com/futapp/futappweb/
    │   ├── entity/         ← Entidades JPA (Persona, Jugador, Arbitro, ...)
    │   ├── repository/     ← Interfaces JpaRepository
    │   ├── service/        ← Lógica de negocio
    │   └── controller/     ← Controladores MVC
    └── resources/
        ├── application.properties
        └── templates/      ← Vistas Thymeleaf
            ├── index.html
            ├── federacion/
            ├── equipo/
            ├── campeonato/
            ├── jugador/
            ├── entrenador/
            ├── arbitro/
            └── partido/
```
