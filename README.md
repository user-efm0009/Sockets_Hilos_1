# Sockets e Hilos - 1

Proyecto práctico de la asignatura Programación de Servicios y Procesos (PSP) que muestra la comunicación cliente‑servidor mediante sockets y la gestión de concurrencia mediante hilos. El objetivo es entender y practicar conceptos básicos de comunicación de red, sincronización y manejo de conexiones concurrentes.

## Descripción del proyecto
Este repositorio contiene una implementación de ejemplo de un servidor que acepta conexiones de múltiples clientes y las atiende concurrentemente usando hilos (threads). Cada cliente puede enviar mensajes al servidor y recibir una respuesta. El proyecto sirve para experimentar con:
- Creación y escucha de sockets en el servidor.
- Aceptación de múltiples conexiones concurrentes.
- Lectura/escritura de datos desde/hacia clientes.
- Manejo de desconexiones y errores básicos en comunicación de red.
- Diagnóstico de bloqueos o problemas en clientes específicos (por ejemplo, Cliente 2).

> Nota: Ajusta la sección de comandos de compilación/ejecución según el lenguaje y la estructura concreta del repositorio (Java, Python, C, etc.). Si quieres, puedo generar los comandos exactos si me confirmas el lenguaje y la estructura de carpetas.

## Estructura sugerida del repositorio

## Entorno de Desarrollo Utilizado
IntelliJ IDEA - Lenguaje Java

## Comportamiento esperado
- El servidor queda a la escucha en un puerto determinado.
- Cada conexión entrante se procesa en su propio hilo para que múltiples clientes puedan interactuar simultáneamente.
- El servidor procesa mensajes recibidos y envía respuestas o confirmaciones.
- El servidor debe manejar desconexiones de clientes de forma segura, liberando recursos asociados.

## Posibles problemas y diagnóstico
- Clientes que no pueden enviar mensajes: revisar si se bloquean en la escritura o en la lectura, revisar buffering, flushing y manejo de streams.
- Bloqueos del servidor: revisar sincronización y uso de recursos compartidos (locks, estructuras compartidas).
- Puertos en uso o permisos: comprobar que el puerto elegido esté libre y que el firewall no bloquee las conexiones.

## Preguntas

1) ¿Qué ocurre con el Cliente 2?

2) ¿Por qué no puede ni siquiera enviar su mensaje?

## Buenas prácticas y recomendaciones
- Hacer un manejo adecuado de excepciones y cerrar sockets en bloques finally/try-with-resources.
- Evitar compartir objetos mutables entre hilos sin sincronización.
- Añadir timeouts de lectura/escritura si procede para evitar bloqueos indefinidos.
- Incluir logs con nivel (INFO/DEBUG/ERROR) para facilitar el diagnóstico.

## Integrantes
- Enrique de la Fuente Méndez
- Daniel Rivera Miranda

Asignatura: Programación de Servicios y Procesos (PSP)
