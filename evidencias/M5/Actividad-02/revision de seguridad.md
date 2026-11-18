# Registro de Revisión de Seguridad 

- **Archivos locales y compilación:** Se verificó revisando el archivo `.gitignore` y ejecutando el comando `git status`, confirmando que la carpeta `/target/` y las configuraciones locales de editores (`.vscode/`, `.idea/`, etc.) están debidamente excluidas del seguimiento de Git.

- **Revisión de historial y código fuente:** Se hizo ejecutando el comando `git log --oneline -n 10` e inspeccionando el archivo `src/main/resources/application.properties`, comprobando que no existen contraseñas, tokens, claves privadas ni variables sensibles expuestas.

- **Resultado:** Repositorio verificado, limpio y conforme a las buenas prácticas de seguridad.