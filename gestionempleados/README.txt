Documentación del Proyecto "Ipartek. Gestión de Empleados"

Esta aplicación gestiona las variaciones de Empleados dentro de un departamento o varios departamentos.



Varias clases son comunes a todos los proyectos, también implementedas en éste, como son:
	Dentro del paquete controller:
		AdminServlet.java
		LoginServlet.java
		LogoutServlet.java
	
	Dentro del paquete filter:
		ServletFilter.java
	
	Dentro del paquete listener:
		InitListener.java
		SessionListener.java
	
	Dentro del paquete dbms:
		ConexionDB.java
		ConexionDBImp.java
	
	Dentro del paquete pojo:
		Usuarios para acceder a la aplicación,	
			Usuario.java
		Para mostrar mensajes:
			Mensaje.java
	
	Dentro del paquete service:
		Util.java
		
	También son extrapolables todos los ficheros incluidos dentro del css, js, y fonts de la caja webapp.