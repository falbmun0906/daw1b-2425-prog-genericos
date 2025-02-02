# 📌 Genéricos en Kotlin

## 📖 Introducción
Los **genéricos** en Kotlin permiten escribir código flexible, reutilizable y seguro en términos de tipos. Son una herramienta fundamental en la **Programación Orientada a Objetos (POO)**, ya que permiten definir clases, interfaces y funciones que pueden operar con **diferentes tipos de datos** sin comprometer la seguridad de tipos.

## 🎯 Objetivos
- Comprender qué son los genéricos y cómo funcionan.
- Explorar su uso en **clases, funciones e interfaces**.
- Identificar su implementación en la práctica del **Ahorcado**.
- Desarrollar una función de extensión genérica `filtrar`.

---

## 🛠️ 1. ¿Qué son los Genéricos?
Los **genéricos** permiten definir estructuras de código que trabajan con diferentes tipos sin perder seguridad en tiempo de compilación.

Por ejemplo, en lugar de escribir múltiples versiones de una clase para diferentes tipos, utilizamos un **tipo parametrizado `T`**:

```kotlin
class Caja<T> {
   private var contenido: T? = null

   fun setContenido(valor: T) {
       contenido = valor
   }

   fun getContenido(): T? {
       return contenido
   }
}
```

En este caso, `T` actúa como un **marcador de tipo**, lo que permite almacenar cualquier tipo de dato en la clase `Caja` sin duplicar código.

---

### 🎯 ¿Cómo se usan?
- Se definen utilizando `<>`, por ejemplo: `List<T>`.
- Se pueden aplicar en **clases**, **funciones** y **interfaces**.
- En el uso práctico, permiten operar con diferentes tipos sin modificar la implementación base.

### 🚀 Ventajas
- ✅ **Código reutilizable**: No es necesario escribir múltiples versiones para cada tipo.
- ✅ **Mayor seguridad de tipos**: Se detectan errores en tiempo de compilación.
- ✅ **Menos casting manual**: Se pueden operar con diferentes tipos sin necesidad de convertirlos explícitamente.
- ✅ **Más legibilidad y mantenibilidad**: Se reduce la redundancia en el código.

---

## 🔹 2. ¿Para qué o dónde se usan?
Los **genéricos** se utilizan en varios escenarios clave:

1. **Colecciones y estructuras de datos** → `List<T>`, `Map<K, V>`, `Set<T>`.
2. **Funciones genéricas** → Métodos reutilizables para cualquier tipo de dato.
3. **Interoperabilidad y abstracción** → Definir clases/interfaces reutilizables.
4. **Tipos seguros** → Evitan errores de conversión y mejoran la robustez.
5. **Casting interno** → Kotlin permite que los genéricos manejen conversiones de tipo sin que el programador tenga que hacer `cast` explícitos.

Ejemplo de **función genérica**:

```kotlin
fun <T> imprimirLista(lista: List<T>) {
   for (elemento in lista) {
       print("$elemento ")
   }
   println()
}

fun main() {
   val numeros = listOf(1, 2, 3, 4, 5)
   val palabras = listOf("Hola", "Mundo")

   imprimirLista(numeros) // Salida: 1 2 3 4 5
   imprimirLista(palabras) // Salida: Hola Mundo
}
```

Aquí `T` permite que la función `imprimirLista` acepte listas de **cualquier tipo**.

---

## 🔍 3. Genéricos en la práctica del Ahorcado
En la implementación del juego del **Ahorcado**, encontramos el uso de genéricos en la siguiente función:

```kotlin
fun <T> MutableSet<T>.pop(): T? {
   val elemento = this.randomOrNull()
   if (elemento != null) {
       this.remove(elemento)
   }
   return elemento
}
```

### 📌 Explicación:
- `T` es un **parámetro genérico** que permite que `pop()` funcione con **cualquier tipo de conjunto** (`MutableSet<T>`).
- `this.randomOrNull()` selecciona un **elemento aleatorio**.
- Si el conjunto **no está vacío**, el elemento es eliminado y retornado.
- Si el conjunto **está vacío**, retorna `null`.

🔹 **Ejemplo de uso:**

```kotlin
fun main() {
   val lista = mutableListOf<Jugador>()
   val conjunto = mutableSetOf<Jugador>()

   lista.pop() // ❌ No permite usar la función de extensión.
   conjunto.pop() // ✅ Funciona correctamente.
}
```

---

## 🚀 4. Funciones de Extensión
Una **función de extensión** añade nuevas funcionalidades a una clase **sin modificar su código fuente**.

📌 **Ejemplo:** Convertir valores `Boolean` a `"SI"` o `"NO"`:

```kotlin
fun Boolean.adverb() = if (this) "SI" else "NO"

fun main() {
   println(true.adverb())  // Salida: SI
   println(false.adverb()) // Salida: NO
}
```

Aquí, la función `adverb()` **extiende** la clase `Boolean` sin necesidad de modificarla.

---

## 📝 5. Implementación de la función `filtrar`
La función `filtrar` será **genérica** y se aplicará a cualquier lista `List<T>`. Recibirá como parámetro una función `(T) -> Boolean` y devolverá los elementos que cumplan la condición.

### ✨ **Ejemplo de uso:**

```kotlin
val lista = mutableListOf("Pablo", "Fran", "Diego", "Dani", "Federico", "Paula")

val pablol1 = lista.filtrar { it.first() == 'P' }
val pablol2 = lista.filtrar { it.first() == 'D' }
val pablol3 = lista.filtrar { it.first() == 'F' }
val pablol4 = lista.filtrar { it.first() == 'A' }

println(pablol1) // [Pablo, Paula]
println(pablol2) // [Diego, Dani]
println(pablol3) // [Fran, Federico]
println(pablol4) // []
```

### 🎯 **Implementación de `filtrar`**

```kotlin
fun <T> List<T>.filtrar(condicion: (T) -> Boolean): List<T> {
   val resultado = mutableListOf<T>()
   
   for (elemento in this) {
       if (condicion(elemento)) {
           resultado.add(elemento)
       }
   }
   return resultado
}
```

📌 **Explicación:**
- `T` es **cualquier tipo de dato**.
- La función `filtrar` recorre la lista y aplica la **condición dada como parámetro**.
- Retorna una nueva lista con los elementos que cumplen la condición.

---

## 🎤 Conclusión
Los **genéricos en Kotlin** permiten escribir código más seguro, reutilizable y flexible. Son una herramienta clave para la programación moderna, especialmente en **estructuras de datos y funciones de extensión**.

✅ **Puntos clave:**
- Permiten definir **clases, interfaces y funciones** que trabajan con **cualquier tipo de dato**.
- Se usan en **colecciones, métodos reutilizables y abstracción**.
- Garantizan **seguridad en tiempo de compilación** y evitan errores de conversión.
