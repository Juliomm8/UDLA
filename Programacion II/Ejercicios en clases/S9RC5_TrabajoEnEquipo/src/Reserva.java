public class Reserva {
    // Nombre del cliente que realiza la reserva
    private String cliente;
    // Referencia a la habitación asignada a esta reserva
    private Habitacion habitacion;

    // Constructor que recibe el nombre del cliente y la habitación a reservar
    public Reserva(String cliente, Habitacion habitacion) {
        this.cliente = cliente;
        this.habitacion = habitacion;

        // Al crear una reserva, se marca la habitación como ocupada
        habitacion.reservar();
    }

    // Devuelve el número de la habitación asociada a esta reserva
    public int getNumeroHabitacion() {
        return habitacion.getNumero();
    }
}
