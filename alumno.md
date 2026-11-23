# especificaciones

Necesitamos crear un sistema para mantener datos de una tabla de alumnos.

# Tecnologia

* Lenguaje: JAVA 25 o superior
* Framework: Spring Boot
  * Spring Web (Spring MVC) para los controladores y endpoints
  * Spring Data JPA (con Hibernate) para la capa de persistencia / repositorios
* Motor de plantillas: Thymeleaf para la visualización (tabla y formulario)
* Base de datos: H2 (en memoria)
* Herramienta de construcción y gestión de dependencias: Maven
* Spring Boot DevTools para recarga en desarrollo (opcional)

# principios

* SRP (Single Responsibility Principle)
* DRY (Don't Repeat Yourself)
* KISS (Keep It Simple, Stupid)


## modelo

* Alumno
  * id integer
  * nombre string
  * edad integer

## base de datos

* alumnos
  * id integer / llave primaria
  * nombre varchar(50)
  * edad integer

## controlador

* AlumnoControlador (anotado con @Controller, inyecta AlumnoServicio por constructor)
    * listar(Model model)
        * responde a GET / (raíz de la aplicación)
        * agrega al modelo "alumnos" (resultado de alumnoServicio.listar())
        * devuelve la vista "alumnos" de Thymeleaf (tabla)
    * insertar(Alumno alumno)
        * responde a GET /insertar
        * creo un alumno vacio para visualizar en el formulario
    * insertar(Alumno alumno)
        * responde a POST /insertar
        * recibe el alumno del formulario con @ModelAttribute
        * delega en alumnoServicio.insertar(alumno)
        * redirige a / (redirect:/) para volver al listado



## visualización

### pagina alumnos.html

* Tabla de alumnos con las siguientes columnas:
  * id
  * nombre
  * edad
* No agregue nada adicional, ni vinculos ni botones. Si hay un vinculo, quitarlo


### pagina insertar.html

* Formulario para agregar un nuevo alumno con los siguientes campos:
  * id cuadro de texto numerico
  * nombre cuadro de texto
  * edad cuadro de texto numerico
  * Boton de insertar
  * Y cada cuadro de texto debe tener su respectiva etiqueta
* No agregue nada adicional, ni vínculos ni botones. Si hay algún vínculo, quitarlo.

## Servicios

* AlumnoServicio
    * listar()
    * insertar(alumno)


