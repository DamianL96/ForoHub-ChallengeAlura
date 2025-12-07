# 🚀 ForoHub (Backend con Spring Boot)

Bienvenido/a al repositorio de **ForoHub**, una API construida con **Spring Boot**. Este proyecto está diseñado para crear topicos, discuciones y preguntas acerca de cursos informaticos.

## 📋 Descripción

Esta aplicación backend proporciona una API RESTful desarrollada con Spring Boot, diseñada para crear topicos y preguntas simulando el comportamiento de un Foro. Utiliza MySQL como base de datos, Spring Security y JWT para autenticacion, y FlyWay para migraciones de base datos. La API está documentada con OpenAPI (Swagger) para facilitar su uso y prueba.

### ✨ Características Principales
- **API RESTful**: Endpoints para gestionar recursos (usuarios, topicos).
- **Autenticación segura**: Soporte para JWT y Spring Security.
- **Persistencia de Datos**: Integracion con MySQL usanfo Spring Data JPA.
- **Validación de Datos**: Validaciones para entradas de usuario y topicos.
- **Documentación automatica**: API documentada con Swagger/OpenAPI.
- **Migraciones de Base de Datos**: Gestión de esquemas con FlyWay.

*Nota*: La API continúa en desarrollo por lo que este README se actualizará con nuevas funcionalidades a medida que se implementen.

## 🛠️ Requisitos

Para ejecutar este proyecto, necesitarás:

- **Java**: Versión 17 o superior (LTS recomendado).
- **Maven**: Versión 3.8.0 o superior.
- **Spring Boot**: Versión 3.5.4
- **MySQL**: Versión 8.0.42.
- **IDE y SO**: IntelliJ, Windows 11.

## ⚙️ Instalación

Sigue estos pasos para configurar el proyecto en tu máquina local:

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/DamianL96/ForoHub-ChallengeAlura.git
   cd ForoHub
   ```

2. **Configura las dependencias**:
   Asegúrate de tener Maven instalado y ejecuta:
   ```bash
   mvn clean install
   ```

3. **Configura las variables de entorno** (si aplica):
   Crea un archivo `.env` o configura las variables en tu sistema con:
   - `SPRING_DATASOURCE_URL`: URL de la base de datos.
   - `SPRING_DATASOURCE_USERNAME`: Nombre de usuario.
   - `SPRING_DATASOURCE_PASSWORD`: Contraseña.

4. **Inicia la aplicación**:
   ```bash
   mvn spring-boot:run
   ```

   La aplicación estará disponible en `http://localhost:8080`.

## 🚀 Uso

Una vez que la aplicación esté en ejecución, puedes interactuar con los endpoints de la API.

Consulta la documentación completa en Swagger o en la sección de **Endpoints** más abajo.

## 📚 Endpoints

| Método | Endpoint                  | Descripción                                    |
|--------|---------------------------|------------------------------------------------|
| POST   | `/usuario`                |Registra un usuario enviado en el body          |
| POST   | `/login`                  |Inicia sesion con email y contraseña            |
| GET    | `/topicos`                |Obtiene un listado de los topicos               |
| GET    | `/topicos/{id}`           |Obtiene un topico especifico detallado          |
| POST   | `/topicos`                |Registra un nuevo topico                        |   
| PUT    | `/topicos`                |Modifica un topico                              |
| DELETE | `/topicos/{id}`           |Elimina un topico permanentemente               |
| POST   | `/topicos/{id}/respuestas`|Agrega una respuesta a un topico especifico     |
| GET    | `/topicos/{id}/respuestas`|Obtiene las respuestas de un topico especifico  |

*Más endpoints se añadirán a medida que se implementen nuevas funcionalidades.*

## 🛡️ Seguridad

- **Autenticación**: JWT para proteger los endpoints.
- **Validaciones**: Entradas validadas para garantizar la integridad de los datos.

## 📈 Próximas funcionalidades

- [x] ~Gestión de Respuestas (CRUD).~  
- [ ] Organizacion y Filtro de Topicos y Respuestas.
- [ ] Despliegue en contenedores con Docker.

## 🤝 Contribuir

¡Las contribuciones son bienvenidas! Si deseas contribuir:

1. Haz un fork del repositorio.
2. Crea una rama para tu funcionalidad (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -m "Añade nueva funcionalidad"`).
4. Envía un pull request.

## 📬 Contacto

Si tienes preguntas o sugerencias, contáctame en damianlambrecht@gmail.com o abre un issue en el repositorio.

---

*Hecho con ❤️ usando Spring Boot*
