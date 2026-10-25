# Progreso — Ejercicio Adicional (compras y contenedores)

Complemento de `CLAUDE.md`. Leer ambos al retomar.

Última actualización: 2026-10-25

## Modo de trabajo acordado

- Claude actúa como profesor/revisor: preguntas, evaluación (Correcto / Parcialmente correcto / Incorrecto) y pistas.
- **No escribir código ni adelantar diseño** salvo pedido explícito del alumno. (Lo pidió en `CondicionNOT` y en la explicación del constructor de copia.)
- Se avanza leyendo el enunciado párrafo por párrafo; los métodos se agregan cuando el enunciado los requiere.
- **No leer `referencia/solucion_proceso_facultad/`** salvo que el alumno lo pida: tiene el examen resuelto y no quiere adelantarse. Está fuera de `src/` a propósito (mismos nombres de clase, sin `package`: si estuviera en `src/` el IDE las mezcla y muestra errores falsos). Excepción: el alumno pidió comparar `Compra`/`CajaMisteriosa` de la copia, y de pasada se vio `getCopia(Condicion)`.

## Dónde quedamos

**Primera y segunda parte implementadas.** Falta:

1. Un `main` en `App` que pruebe todo (hoy solo "Hello, World!").
2. La evaluación final, realista, de si la solución aprobaría un examen de Programación 2.

Detalle pendiente chico (visibilidad): `ContenedorExpress.crearCopiaVacia()` quedó `public` pero en `Contenedor` es `protected`. Compila (se puede ensanchar la visibilidad al sobrescribir), pero conviene que sea `protected` en las dos.

## Estado de las clases (`src/`)

| Clase | Estado |
|---|---|
| `Destinatario` | Nombre, apellido, dirección y ciudad, con getters y setters (los setters no los pide el enunciado). `getCopia()` crea un `Destinatario` nuevo con los mismos datos. |
| `ElementoEnvio` | Clase abstracta (abstracción común del Composite). Abstractos: `estaEntregado()`, `getCiudadDestino()`, `getTiempoEstimadoEntrega()`, `contarCompras(Condicion)`, `getCopia()`, `getCopia(Condicion)`. Sin atributos. |
| `Compra` | Hoja. Atributos: `ids`, `destinatario`, `entregado`, `tiempoEstimadoEntrega`, `distancia`. `getCantIds`, `tieneId`, `getCopiaIds` (copia de la lista), `getDestinatario` (devuelve copia), `contarCompras` (1 o 0), `getCopia()` (copia fiel: destinatario nuevo, ids y estado de entrega), `getCopia(Condicion)` (la copia si cumple, `null` si no). Dejadas como referencia en comentarios: opción a/b y opción 2 (constructor de copia, comentado). |
| `CajaMisteriosa` | `extends Compra`. Sobrescribe `tieneId` (siempre `true`) y `getCopia()` (crea una `CajaMisteriosa` con la opción 1; la opción 2 con constructor de copia quedó comentada). `getCopia(Condicion)` se hereda y usa `this.getCopia()`, que ya es polimórfico. |
| `Contenedor` | Compuesto. `private List<ElementoEnvio> elementos`. Ciudad, tiempo, entregado, `agregarElemento`, `contarCompras` (suma recursiva), `crearCopiaVacia()` (`protected`, devuelve `new Contenedor()`), `getCopia()` (copia cada elemento a un contenedor vacío) y `getCopia(Condicion)` (idem, saltea los `null`, devuelve `null` si queda vacío). |
| `ContenedorExpress` | `extends Contenedor`. Sobrescribe `getTiempoEstimadoEntrega()` (`super` menos 5, piso de 1; constantes `static final`) y `crearCopiaVacia()` (devuelve `new ContenedorExpress()`). Hereda los dos `getCopia` sin tocarlos. Sin constructor propio (no tiene estado de instancia). |
| `Condicion` | Clase abstracta con `cumple(Compra c)`. |
| `CondicionCantidadProductos` | "Más de N" productos; N por constructor; usa `getCantIds()`. |
| `CondicionCiudadDestino` | Ciudad igual a la indicada; el `equals` va del lado de la condición (nunca `null`). |
| `CondicionCompraEntregada` | `c.estaEntregado()`. |
| `CondicionAND` / `CondicionNOT` | Combinan `Condicion`s (reciben el tipo abstracto). "No entregadas" = `NOT(Entregada)`. |
| `App` | Todavía sin pruebas. |

`CondicionOR` no existe: el enunciado dice "combinaciones lógicas" sin exigir OR. Sería igual a `CondicionAND` con `||`.

Verificado con `javac` y programas de prueba descartables (fuera del repo): conteo con 3 niveles de anidamiento y todas las condiciones; copia profunda independiente del original; copia filtrada (productos, entregadas, no entregadas, ninguna cumple → `null`, contenedor que queda vacío desaparece); copia de `ContenedorExpress` conserva clase y tiempo, tanto completa como filtrada, y también anidado.

## Decisiones tomadas (y por qué)

- **Abstracción común = clase abstracta** `ElementoEnvio`: compra y contenedor forman una familia de objetos relacionados (criterio del profesor Luis).
- **Una compra puede crearse sin ids**, aunque el enunciado dice "uno o más". Fue una decisión consciente.
- **El contenedor calcula entregado, ciudad y tiempo a partir de sus elementos.** No los guarda en atributos, para que no se desactualicen.
- **Contenedor vacío:** `estaEntregado()` devuelve `true` (lógica de "todos"; ninguno pendiente) y el tiempo es `0`.
- **`agregarElemento` (opción A, enunciado literal):** se agrega si la ciudad del contenedor es `null` o coincide con la del elemento. Consecuencia aceptada: pueden existir contenedores sin ciudad, y un contenedor vacío **no** entra a un contenedor que ya tiene ciudad. Al armar estructuras en un `main`, llenar los hijos antes de agregarlos al padre. Se descartó la opción B (rechazar elementos sin ciudad) porque el enunciado no la pide.
- **`x.equals(null)` da `false` sin explotar; `null.equals(x)` sí explota.** Va a la izquierda el valor que seguro no es `null`. `||` y `&&` hacen cortocircuito.
- **`ContenedorExpress` con constantes `static final`, sin constructor con parámetros ni setters.** El enunciado fija 5 y 1 para todos los express; con parámetros alguien podría crear uno con un mínimo absurdo. Contenedor vacío en Express: la fórmula con el piso da `1`, sin caso especial.
- **`elementos` es `private`** (no `protected`): ninguna subclase lo necesita.
- **El criterio de conteo es una `Condicion`, no una Strategy.** El algoritmo (recorrer y contar) no cambia; lo que varía es el criterio booleano.
- **`cumple(Compra c)`:** el enunciado dice que se cuentan solo compras, y los criterios usan datos que solo tiene `Compra`. Con `cumple(ElementoEnvio)` habría que hacer cast o agregar a `ElementoEnvio` métodos que no tienen sentido para el contenedor. En otro examen puede corresponder `Elemento` (cuando la condición decide si se puede agregar un elemento completo): no se decide automáticamente.
- **`contarCompras(Condicion)` devuelve `int`**, declarado en `ElementoEnvio`. Hoja: 1 o 0. Compuesto: suma. Devolver lista (`add` / `addAll`) solo si se necesitaran las compras mismas.
- **`CajaMisteriosa` es subclase de `Compra`** porque cambia un comportamiento (`tieneId`) y tiene que seguir siendo una `Compra`. `tieneId` es **concreto** en `Compra` y se sobrescribe; no `abstract`, porque haría abstracta a `Compra` y obligaría a inventar una subclase `CompraComun`.
- **`getIds()` se borró; se usa `getCantIds()`.** Nadie de afuera necesita la lista de ids.
- **Copia en profundidad = copia fiel.** Comparte con el original **ningún** objeto mutable: `Destinatario` nuevo y lista de ids nueva. Conserva el estado de entrega, el tiempo y la distancia. (La solución de referencia de la facultad comparte el `Destinatario` y no copia `entregado`; la nuestra cumple mejor "al modificar la copia no se modifica el original".)
- **Quién sabe copiarse:** `Destinatario` se copia a sí mismo (`getCopia()`); `Compra` no arma el `Destinatario` campo por campo. Defensa también al devolver: `getDestinatario()` devuelve una copia. El constructor de `Compra` guarda la referencia que le pasan (un alias externo no se cubre; fuera del alcance del enunciado).
- **Tres formas de copiar una compra**, dejadas como referencia en los comentarios: (1a) con métodos públicos `agregarId`/`marcarEntregado`; (1b) asignando los atributos directo (`private` es por clase, no por objeto); (2) constructor de copia `Compra(Compra otra)` + `super(otra)` en la caja. En la caja, la 1 usa `getCopiaIds()` porque `ids` es privado.
- **Operación de copia declarada `abstract` en `ElementoEnvio`** (`getCopia()` y `getCopia(Condicion)`), sin `instanceof`. `Compra.getCopia()` puede devolver `ElementoEnvio` y el contenedor trata a todos igual.
- **Convención de la copia filtrada:** `null` significa "esto no entra en el resultado". La compra devuelve `null` si no cumple; el contenedor saltea los `null` y **devuelve `null` si queda vacío** (el enunciado pide que los contenedores vacíos no aparezcan). Un solo chequeo resuelve los dos casos. Hay que usar el resultado ya obtenido (no volver a llamar a `getCopia(c)`: duplicaría el trabajo en cada nivel).
- **Tipo de la copia de un contenedor:** un método `protected crearCopiaVacia()` en `Contenedor` separa "qué clase crear" (cambia) de "recorrer y copiar" (igual). `ContenedorExpress` sobrescribe solo ese método. Es polimorfismo: el tipo real decide qué `crearCopiaVacia()` se ejecuta.
- **Variable local de tipo `Contenedor`** (no `ElementoEnvio`) al armar la copia: el tipo declarado decide qué métodos se pueden llamar (`agregarElemento` solo existe en `Contenedor`). La firma puede seguir devolviendo `ElementoEnvio`.
- **Sin `@Override`:** la cátedra indicó que no hace falta.
- **Se usa polimorfismo, sin `instanceof`**, en todo el diseño.

## Correcciones pendientes (estilo, opcional)

- `crearCopiaVacia()` en `ContenedorExpress` debería ser `protected` (igual que en `Contenedor`).
- Constantes de `ContenedorExpress` en mayúsculas y `private static final`; `CondicionAND` con atributos `private` (hoy sin modificador); `Contenedor.elementos` podría ser `final`; `getCopiaIds()` podría ser `private` si nadie de afuera lo usa (la caja sí lo usa).
- Alinear la sangría de los bloques de la opción 1 en `Compra` y `CajaMisteriosa`.
- Los rótulos "OPCION 1/2" y a/b de los comentarios de `Compra` y `CajaMisteriosa` son para referencia del alumno.

## Qué falta

1. ~~Agregar elementos con validación de ciudad.~~ Hecho.
2. ~~`ContenedorExpress`.~~ Hecho.
3. ~~Contar compras mediante condiciones combinables.~~ Hecho.
4. ~~`CajaMisteriosa`.~~ Hecho.
5. ~~Copia en profundidad de un contenedor.~~ Hecho.
6. ~~Copia en profundidad filtrada.~~ Hecho.
7. Pruebas desde `main` (`App`).
8. Evaluación realista de si la solución aprobaría.
