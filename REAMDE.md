# Programa en consola, sin UI

- Se ejecutará todo en un main

# Situación
- Un banco tiene 3 cajeros automáticos y varios clientes
// List Cajero> List Cliente>
- Un único cajero puede atender a un único cliente a la vez
- Cada retirada tarda un tiempo variable
- Todos los retiros salen de una cuenta bancaria en común

# Clases

- Banco saldo + método para retirar
- Cajero atiende a clientes (se ejecuta en un hilo)
- Cliente nombre + cantidad a retirar
- Main crea todo, lanza los hilos y muestra el resumen final

# Concurrencia
- Los 3 cajeros trabajan a la vez
- Cada cajero atiende clientes de una cola/lista compartida
- Cada cliente es atendido una única vez
- Cuando no quedan clientes en cola, el cajero finaliza la ejecución while()
- El main debe esperar a que terminen los 3 cajeros usando join()

# Retirada de dinero
- La cuenta es compartida
- Si hay saldo suficiente -> se retira y devuelve true
- Si no hay saldo suficiente -> no se retira y devuelve false
- El método retirar debe ser atómico, comprueba saldo y después retira.

# Simulación de tiempo
- Cada operación debe tardar n tiempo en ejecutarse entre 200 y 1200ms

# Salida por consola
- Cajero, Cliente,Cantidad Solicitada, OK / Denegado, saldo tras la operación, tiempo simulado
- FORMATO
- [Cajero-1] Cliente Ana solicita 120€ -> OK | saldo restante: 380€ | t=540ms

# Resumen Final del Main
=== Resumen Final ===
- Saldo final= x
- Operaciones Ok = x
- Operaciones Denegadas = x
- Total retirado = x
- Clientes atendidos = x

# Restricciones 
- Prohibido usar thread.stop(), suspend(), resume()
- No vale un único hilo
- La aplicación debe terminar sola
