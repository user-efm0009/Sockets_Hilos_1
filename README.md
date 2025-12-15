# Sockets_Hilos_1

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
- src/              → Código fuente (servidor y cliente)
- bin/              → Archivos compilados (si aplica)
- scripts/          → Scripts de ejecución y prueba
- tests/            → Casos de prueba o escenarios de carga
- README.md         → Este fichero

(Ajusta la estructura real si difiere)

## Requisitos
- Entorno de desarrollo según el lenguaje (JDK para Java, Python 3, compilador C, etc.)
- Acceso a la red local (para pruebas entre máquinas) o localhost para pruebas locales
- Permisos para abrir puertos en la máquina donde se ejecute el servidor

## Compilación y ejecución (ejemplo genérico)
1. Compila (si aplica):
   - Java: `javac -d bin src/*.java`
   - C: `gcc -o bin/servidor src/servidor.c` (ejemplo)
2. Ejecuta el servidor:
   - `java -cp bin Server` o `./bin/servidor`
3. Ejecuta uno o varios clientes en otras terminales:
   - `java -cp bin Client` o `./bin/cliente`
4. Envía mensajes desde los clientes y observa la salida del servidor.

Si necesitas, puedo escribir comandos concretos una vez me confirmes el lenguaje y la estructura del proyecto.

## Comportamiento esperado
- El servidor queda a la escucha en un puerto determinado.
- Cada conexión entrante se procesa en su propio hilo para que múltiples clientes puedan interactuar simultáneamente.
- El servidor procesa mensajes recibidos y envía respuestas o confirmaciones.
- El servidor debe manejar desconexiones de clientes de forma segura, liberando recursos asociados.

## Posibles problemas y diagnóstico
- Clientes que no pueden enviar mensajes: revisar si se bloquean en la escritura o en la lectura, revisar buffering, flushing y manejo de streams.
- Bloqueos del servidor: revisar sincronización y uso de recursos compartidos (locks, estructuras compartidas).
- Puertos en uso o permisos: comprobar que el puerto elegido esté libre y que el firewall no bloquee las conexiones.

## Preguntas / Análisis (Rellena las respuestas abajo)
A continuación se añade una sección para analizar un caso concreto. Rellena las respuestas con la observación, trazas y pasos para reproducir el problema.

1) ¿Qué ocurre con el Cliente 2?
   - Observaciones:
     - Estado al iniciar: 
     - Mensajes mostrados en el cliente:
     - Mensajes/errores recibidos en el servidor:
     - Comportamiento comparado con Cliente 1:
   - Respuesta: 

2) ¿Por qué no puede ni siquiera enviar su mensaje?
   - Posibles causas a investigar:
     - Cliente no establece conexión (error al conectar o timeout).
     - Socket conectado pero bloqueado en escritura por buffering o por no hacer flush.
     - Protocolo de aplicación: el servidor espera un prefijo/tamaño o handshake que el Cliente 2 no envía.
     - Recurso compartido bloqueado en el servidor (deadlock) impide procesar nuevos datos.
     - Límite de conexiones alcanzado o el servidor rechazó la conexión.
   - Pasos sugeridos para depurar:
     - Comprobar logs del servidor y del cliente.
     - Añadir prints/trazas justo después de la apertura del socket, antes y después de enviar/recibir.
     - Probar con telnet/nc para enviar manualmente datos y ver la respuesta del servidor.
     - Comparar exactamente el flujo de red (tcpdump/wireshark) entre Cliente 1 y Cliente 2.
     - Verificar excepciones no manejadas en el servidor que puedan cerrar el handler del cliente.
   - Respuesta:

(Deja espacio para que el equipo escriba aquí los resultados del diagnóstico)

## Buenas prácticas y recomendaciones
- Hacer un manejo adecuado de excepciones y cerrar sockets en bloques finally/try-with-resources.
- Evitar compartir objetos mutables entre hilos sin sincronización.
- Añadir timeouts de lectura/escritura si procede para evitar bloqueos indefinidos.
- Incluir logs con nivel (INFO/DEBUG/ERROR) para facilitar el diagnóstico.

## Integrantes
- Enrique de la Fuente Méndez
- Daniel Rivera Miranda

Asignatura: Programación de Servicios y Procesos (PSP)

## Licencia
Indica aquí la licencia del proyecto (por ejemplo, MIT) o elimina esta sección si no procede.

---

Si quieres, adapto este README al lenguaje concreto del repositorio (Java/Python/C/C++), añado comandos de compilación/ejecución exactos y un ejemplo de protocolo (formato de mensajes) y pruebas automatizadas. ¿Con qué lenguaje y estructura trabaja el proyecto?
