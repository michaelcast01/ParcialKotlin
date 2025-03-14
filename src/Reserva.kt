data class Reserva(
    val id: Int,
    val idHuesped: Int,
    val nombreHuesped: String,
    val emailHuesped: String,
    val numeroHabitacion: Int,
    val tipoHabitacion: String,
    val precioPorNoche: Double,
    val nochesReservadas: Int
) {
    private fun calcularTotal(): Double = precioPorNoche * nochesReservadas

    fun detallesReserva(): String {
        return """
            ID Reserva: $id
            ID Huésped: $idHuesped
            Nombre: $nombreHuesped
            Email: $emailHuesped
            Habitación: $numeroHabitacion ($tipoHabitacion)
            Precio por noche: $precioPorNoche
            Noches reservadas: $nochesReservadas
            Total a pagar: ${calcularTotal()}
            --------------------------
        """.trimIndent()
    }
}
