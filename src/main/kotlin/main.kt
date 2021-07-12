import kotlin.system.exitProcess

// Declaramos los valores de nuestras respuestas
const val RESPUESTA_AFIRMATIVA = "✅"
const val RESPUESTA_NEGATIVA = "❌"
const val RESPUESTA_DUDOSA = "?"

//Unimos las respuestas con los valores
val Posiblesrespuestas = mapOf(
    "Sí" to RESPUESTA_AFIRMATIVA,
    "Es cierto" to RESPUESTA_AFIRMATIVA,
    "Totalmente" to RESPUESTA_AFIRMATIVA,
    "Sin duda" to RESPUESTA_AFIRMATIVA,
    "Pregunta en otro momento" to RESPUESTA_DUDOSA,
    "No puedo decirte en este momento" to RESPUESTA_DUDOSA,
    "Puede que si o puede que no" to RESPUESTA_DUDOSA,
    "No va a suceder" to RESPUESTA_NEGATIVA,
    "No cuentes con ello" to RESPUESTA_NEGATIVA,
    "Definitivamente no" to RESPUESTA_NEGATIVA,
    "No lo creo" to RESPUESTA_NEGATIVA,
)

fun RealizarPregunta(){
    println("QUE ME QUIERES PREGUNTAR")
    readLine()
    println("ESO ES SENCILLO... CON RESPECTO A ESO DEBO DECIRTE QUE:")
    val Respuesta = Posiblesrespuestas.keys.random()
    println(Respuesta)
}

fun RespuestaTipo(opcionRespuesta : String = "TODOS") {
    when(opcionRespuesta){
        "TODOS" -> Posiblesrespuestas.keys.forEach{respuesta -> println(respuesta)}
        RESPUESTA_AFIRMATIVA -> Posiblesrespuestas.filterValues { values -> values == RESPUESTA_AFIRMATIVA }
            .also { respuestaSi -> println(respuestaSi.keys) }
        RESPUESTA_DUDOSA -> Posiblesrespuestas.filterValues { values -> values == RESPUESTA_DUDOSA }
            .also { respuestamaso -> println(respuestamaso.keys) }
        RESPUESTA_NEGATIVA -> Posiblesrespuestas.filterValues { values -> values == RESPUESTA_NEGATIVA }
            .also { respuestaNo -> println(respuestaNo.keys) }
    }
}

fun MostrarRespuestas() {
    println("QUE TIPO DE RESPUESTAS QUIERES VER")
    println("1. Todas las respuestas")
    println("2. Las respuestas positivas")
    println("3. Las respuesdas dudosas")
    println("4. Las respuestas negativas")

    val opcionRespuesta = readLine()
    when(opcionRespuesta){
        "1" -> RespuestaTipo()
        "2" -> RespuestaTipo(opcionRespuesta = RESPUESTA_AFIRMATIVA)
        "3" -> RespuestaTipo(opcionRespuesta = RESPUESTA_DUDOSA)
        "4" -> RespuestaTipo(opcionRespuesta = RESPUESTA_NEGATIVA)
        else -> println ("RESPUESTA NO VALIDA, HASTA PRONTO")
    }
}

fun Salir() {
    println("HASTA PRONTO AVENTURERO")
}
fun MostrarError() {
    println("RESPUESTA NO VALIDA, INGRESA UNA NUEVA")
}
fun Menu() : String? {
    println("BOLA MAGICA CREADA EN KOTLIN")
    println("QUE DESEAS MI JOVEN VISITANTE")
    println("1. Realizar Una pregunta")
    println("2. revisar las respuestas")
    println("3. Salir")
    val opcion = readLine()
    return opcion
}
fun main(){
    while (true){
        val opcion = Menu()
        when (opcion) {
            /* se usan como string debido a que el ReadLine recibe
            Un string nulleable*/
            "1" -> RealizarPregunta()
            "2" -> MostrarRespuestas()
            "3" -> {
                Salir()
                break
            }
            else -> MostrarError()
        }
    }
}





