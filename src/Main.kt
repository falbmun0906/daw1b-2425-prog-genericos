package es.iesra.prog2425_ahorcado

fun main() {
    val palabras = Palabra.generarPalabras(cantidad = 2, tamanioMin = 7, tamanioMax = 7, idioma = Idioma.ES)

    palabras.add(Palabra("cúrcuma"))

    var seguirJugando : Boolean
    do {
        val palabraOculta = palabras.pop()
        if (palabraOculta != null) {
            val jugador = Jugador(intentos = 6, mutableSetOf())
            val juego = Juego(palabraOculta, jugador)

            juego.iniciar()
            seguirJugando = juego.preguntar("\"¿Quieres jugar otra partida?\"")
        } else {
            println("No existen más palabras ocultas...")
            seguirJugando = false
        }
    } while (seguirJugando)
}

//TODO: Crear una función de extensión quitarAcentos para la clase Char
//      Intentad utilizarlo en el programa para ser capaces de encontrar coincidencias con vocales acentuadas.
fun Char.quitarAcentos(): Char {
/*
    //Yo crearía un mapa de vocales acentuadas como clave con el valor como la vocal sin acentuar
    //Vocales minúsculas y mayúsculas.
    // Después retornaría el valor de la clave para el reciever si se ha encontrado o el mismo reciever.
    *//*
    El receiver es la instancia del tipo al que se extiende la función. En otras palabras, es el objeto
    sobre el cual la función de extensión será llamada. Dentro de la función de extensión, puedes acceder
    a las propiedades y métodos de esta instancia utilizando this.
    *//*
*/
    val acentosMap = mapOf('á' to 'a', 'é' to 'e', 'í' to 'i', 'ó' to 'o', 'ú' to 'u',
        'Á' to 'A', 'É' to 'E', 'Í' to 'I', 'Ó' to 'O', 'Ú' to 'U')

    return acentosMap[this]?: this

/*    var letra = ""

    for (caracter in this){

        letra += acentosMap.getOrDefault(caracter, caracter)
    }

    return letra*/
}

/**
 * Elimina y retorna un elemento aleatorio de este [MutableSet].
 * Si el conjunto está vacío, retorna `null`.
 *
 * @receiver MutableSet<T> El conjunto mutable del cual se eliminará el elemento.
 * @return [T]? El elemento eliminado del conjunto o `null` si el conjunto está vacío.
 * @param T El tipo de elementos que contiene el conjunto.
 */
fun <T> MutableSet<T>.pop(): T? {
    val elemento = this.randomOrNull()
    if (elemento != null) {
        this.remove(elemento)
    }
    return elemento
}

// Caja genérica
class Caja<T< {
    private var contenido: T? = null

    fun setContenido(valor: T) {
        contenido = valor
    }

    fun getContenido(): T? {
        return contenido
    }
}

// Uso de la clase genérica
fun main() {
    val cajaString = Caja<String> ()
    cajaString.setContenido("Hola Mundo")
    println(cajaString.getContenido()) // Salida: Hola Mundo

    val cajaInt = Caja<Int>()
    cajaInt.setContenido(42)
    println(cajaInt.getContenido()) // Salida: 42
}

// Función genérica
fun <T> imprimirLista(lista: List<T>) {
    for elemento in lista) {
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

fun <T> MutableSet<T>.pop(): T? {
    val elemento = this.randomOrNull()
    if (elemento != null) {
        this.remove(elemento)
    }
    return elemento
}

fun main() {
    val lista = mutableListOf<Jugador>()

    val conjunto = mutableSetOf<Jugador>()

    lista.pop() // No permite usar la función de extensión.
    conjunto.pop() // Permite usar la función de extensión.
}
