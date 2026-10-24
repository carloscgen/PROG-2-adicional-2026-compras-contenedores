# Progreso — Ejercicio Adicional (compras y contenedores)

Complemento de `CLAUDE.md`. Leer ambos al retomar.

Última actualización: 2026-10-24

## Modo de trabajo acordado

- Claude actúa como profesor/revisor: preguntas, evaluación (Correcto / Parcialmente correcto / Incorrecto) y pistas.
- **No escribir código ni adelantar diseño** salvo pedido explícito del alumno.
- Se avanza leyendo el enunciado párrafo por párrafo; los métodos se agregan cuando el enunciado los requiere.

## Dónde quedamos en el enunciado (primera parte)

Último párrafo resuelto:

> "...Un contenedor se considera entregado si todos sus elementos están entregados."

(La ciudad del primer elemento y el tiempo máximo también están implementados.)

**Siguiente paso:** el método para agregar elementos a un contenedor, validando que la ciudad del nuevo elemento coincida con la del contenedor. Si el contenedor todavía no tiene ciudad (`getCiudadEnvio()` devuelve `null` cuando está vacío), se agrega. Ojo con el lado del `equals` que puede ser `null`.

## Estado de las clases (`src/`)

| Clase | Estado |
|---|---|
| `Destinatario` | Nombre, apellido, dirección y ciudad, con getters y setters. Los setters no los pide el enunciado; quedan a criterio del alumno. |
| `ElementoEnvio` | Clase abstracta (abstracción común del Composite). Métodos abstractos: `estaEntregado()`, `getCiudadEnvio()`, `getTiempoEstimadoEntrega()`. Sin atributos. |
| `Compra` | Hoja. Atributos: `ids` (`List<String>`), `destinatario`, `entregado`, `tiempoEstimadoEntrega`, `distancia`. Métodos: `agregarId`, `getIds` (devuelve una copia), `getDestinatario`, `marcarEntregado`, `estaEntregado`, `getDistancia`, `getTiempoEstimadoEntrega`, `getCiudadEnvio`. |
| `Contenedor` | Compuesto. `List<ElementoEnvio> elementos`, creada en el constructor. Implementa ciudad (la del primer elemento, o `null` si está vacío), tiempo (el máximo, 0 si está vacío) y entregado (todos entregados; vacío → `true`). Todavía **no tiene método para agregar**. |
| `App` | Todavía sin pruebas (solo "Hello, World!"). |

La versión anterior del ejercicio está en `src/wip-facultad/` y no se usa como referencia.

## Decisiones tomadas (y por qué)

- **Abstracción común = clase abstracta** `ElementoEnvio`: compra y contenedor forman una familia de objetos relacionados (criterio del profesor Luis).
- **Una compra puede crearse sin ids**, aunque el enunciado dice "uno o más". Fue una decisión consciente.
- **El contenedor calcula entregado, ciudad y tiempo a partir de sus elementos.** No los guarda en atributos, para que no se desactualicen.
- **Contenedor vacío:** `estaEntregado()` devuelve `true` (lógica de "todos"; ninguno pendiente) y el tiempo es `0`.
- **Sin `@Override`:** la cátedra indicó que no hace falta.
- **Se usa polimorfismo, sin `instanceof`**, para recorrer los elementos.

## Correcciones pendientes

- `getDestinatario()` devuelve el `Destinatario` original, que es mutable porque tiene setters. Retomar en la copia en profundidad (segunda parte).

## Qué falta

Primera parte:
1. Agregar elementos con validación de ciudad.
2. `ContenedorExpress`: el máximo menos 5 horas, con mínimo de 1 hora.
3. Contar compras mediante condiciones combinables: más de 10 productos, ciudad Olavarría, entregadas, no entregadas, AND/OR/NOT. Cuenta solo compras, a cualquier nivel de profundidad.
4. `CajaMisteriosa`: cuando se le pregunta si tiene un id de producto, siempre responde que sí. Evitar duplicar la lógica de `Compra`.

Segunda parte:
5. Copia en profundidad de un contenedor, manteniendo la estructura.
6. Copia en profundidad filtrada por condiciones. Los contenedores que queden vacíos no se incluyen.

Al final: pruebas desde `main` y una evaluación realista de si la solución aprobaría.
