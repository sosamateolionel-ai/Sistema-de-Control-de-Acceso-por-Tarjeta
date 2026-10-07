# Sistema de Control de Acceso RFID

## Descripción

Este proyecto simula un sistema de control de acceso mediante **tarjetas RFID**.

El sistema permite registrar diferentes zonas con un nivel mínimo de acceso y verificar si una tarjeta tiene los permisos suficientes para ingresar.

Un lector de tarjetas detecta la tarjeta y consulta al controlador de acceso. Dependiendo del nivel de la tarjeta, la puerta se abre o permanece cerrada.

## Funcionamiento

Al iniciar el programa se crea un `ControladorDeAcceso`.

Se registran dos zonas:

* **Oficinas Generales** → nivel mínimo `1`.
* **Sala de Servidores** → nivel mínimo `3`.

Luego se crea un lector ubicado en la puerta de la Sala de Servidores.

También se crean dos tarjetas:

* `RFID-9001` → nivel de acceso `3`.
* `RFID-4521` → nivel de acceso `1`.

Se realizan dos pruebas:

1. La tarjeta con nivel `3` intenta acceder a la Sala de Servidores, que requiere nivel `3`. El acceso es autorizado.
2. La tarjeta con nivel `1` intenta acceder a la misma zona. El acceso es denegado porque no alcanza el nivel requerido.

## Clase `TarjetaRFID`

Representa una tarjeta utilizada para ingresar a las diferentes zonas.

### Atributos

* `codigo`: código identificador de la tarjeta.
* `nivelAcceso`: nivel de permisos de la tarjeta.

Los atributos están encapsulados utilizando `private`.

### Métodos

* `getCodigo()`: devuelve el código de la tarjeta.
* `getNivelAcceso()`: devuelve el nivel de acceso.

## Clase `ControladorDeAcceso`

Es la clase encargada de administrar los permisos de las diferentes zonas.

### Atributo

```java
private Map<String, Integer> permisosPorZona;
```

Utiliza un `HashMap` para almacenar:

```text
Zona → Nivel mínimo requerido
```

Por ejemplo:

```text
Sala de Servidores → 3
Oficinas Generales → 1
```

### `registrarZona()`

Permite registrar una zona y establecer el nivel mínimo necesario para ingresar.

```java
registrarZona("Sala de Servidores", 3);
```

### `verificarAcceso()`

Comprueba si una tarjeta puede acceder a una determinada zona.

Primero verifica que la zona exista en el sistema.

Después compara:

```text
Nivel de la tarjeta >= Nivel requerido
```

Si se cumple la condición, el acceso es autorizado.

Si no se cumple, el acceso es denegado.

## Clase `LectorTarjetas`

Representa el dispositivo encargado de detectar las tarjetas RFID.

### Atributos

* `ubicacion`: lugar donde está instalado el lector.
* `controlador`: referencia al `ControladorDeAcceso`.

La referencia al controlador representa una **asociación entre clases**.

### `leerTarjeta()`

Este método recibe una tarjeta y una zona a la que se desea acceder.

El lector:

1. Detecta la tarjeta.
2. Solicita al controlador verificar el acceso.
3. Recibe el resultado.
4. Abre la puerta si el acceso fue autorizado.
5. Mantiene la puerta cerrada si el acceso fue rechazado.

## Ejemplo de funcionamiento

### Prueba 1: tarjeta válida

La tarjeta:

```text
Código: RFID-9001
Nivel: 3
```

intenta acceder a:

```text
Sala de Servidores
Nivel requerido: 3
```

Como `3 >= 3`, el acceso es autorizado:

```text
Acceso autorizado: tarjeta RFID-9001 (nivel 3) puede ingresar a Sala de Servidores.
[Puerta Sala de Servidores] Puerta abierta.
```

### Prueba 2: tarjeta inválida

La tarjeta:

```text
Código: RFID-4521
Nivel: 1
```

intenta acceder a una zona que requiere nivel `3`.

Como `1 < 3`, el acceso es denegado:

```text
Acceso denegado: tarjeta RFID-4521 (nivel 1) no alcanza el nivel requerido (3).
[Puerta Sala de Servidores] Acceso rechazado, puerta permanece cerrada.
```

## Relación entre las clases

```text
TarjetaRFID
     │
     │ es leída por
     ▼
LectorTarjetas
     │
     │ consulta
     ▼
ControladorDeAcceso
     │
     │ verifica
     ▼
Permisos por zona
```

El `LectorTarjetas` mantiene una referencia al `ControladorDeAcceso`, mientras que el controlador administra los niveles de acceso mediante un `HashMap`.

## Conceptos utilizados

* Programación Orientada a Objetos.
* Clases y objetos.
* Constructores.
* Encapsulamiento.
* Atributos privados.
* Getters.
* Asociación entre clases.
* Referencias a objetos.
* `HashMap`.
* Interfaz `Map`.
* Condicionales `if/else`.
* Valores booleanos.
* Comparación de niveles de acceso.
* Validación de permisos.
* Comunicación entre objetos.

## Ejecución

<img width="1051" height="460" alt="image" src="https://github.com/user-attachments/assets/c6155d80-2e0d-4bdd-bd5f-949e2192ece4" />
