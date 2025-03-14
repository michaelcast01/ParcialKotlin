fun main() {
    val reservas = mutableListOf<Reserva>()
    var idCounter = 1

    while (true) {
        println(
            """
            Menú:
            1. Registrar reserva
            2. Cancelar reserva
            3. Mostrar reservas
            4. Salir
            Elige opción:
            """.trimIndent()
        )
        val opciones = readlnOrNull()?.toIntOrNull()

        if (opciones == 4) {
            println("Gracias por usar el sistema.")

            println("Vuelva pronto")
        }

        when (opciones) {
            1 -> {
                println("ID Huésped:")
                val idHuesped = readln().toInt()
                println("Nombre Huésped:")
                val nombreHuesped = readln()
                println("Email Huésped:")
                val emailHuesped = readln()
                println("Número de Habitación:")
                val numeroHabitacion = readln().toInt()
                println("Tipo de Habitación:")
                val tipoHabitacion = readln()
                println("Precio por Noche:")
                val precioPorNoche = readln().toDouble()
                println("Noches Reservadas:")
                val nochesReservadas = readln().toInt()

                var habitacionOcupada = false
                for (reserva in reservas) {
                    if (reserva.numeroHabitacion == numeroHabitacion) {
                        habitacionOcupada = true

                    }
                }

                if (habitacionOcupada) {
                    println("Error: La habitación ya está reservada.")
                } else {
                    val nuevaReserva = Reserva(idCounter++, idHuesped, nombreHuesped, emailHuesped, numeroHabitacion, tipoHabitacion, precioPorNoche, nochesReservadas)
                    reservas.add(nuevaReserva)
                    println("Reserva registrada:\n${nuevaReserva.detallesReserva()}")
                }
            }
            2 -> {
                if (reservas.isEmpty()) {
                    println("No hay reservas para cancelar.")
                } else {
                    val primerId = reservas.minOf { it.id }
                    println("Ingrese ID de la reserva comeienza desde $primerId):")
                    val id = readln().toInt()

                    var encontrada = false
                    for (i in reservas.indices) {
                        if (reservas[i].id == id) {
                            reservas.removeAt(i)
                            encontrada = true
                        }
                    }

                    if (encontrada) println("Reserva con ID $id cancelada.")
                    else println("No se encontró la reserva con ese ID.")
                }
            }
            3 -> {
                if (reservas.isEmpty()) println("No hay reservas activas.")
                else {
                    println("Reservas Ocupadas")
                    var index = 1
                    for (reserva in reservas) {
                        println("$index. ${reserva.detallesReserva()}")
                        index++
                    }
                }
            }
            else -> println("Opción inválida.")
        }
    }
}
