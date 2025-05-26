import java.util.ArrayList;

public class Hotel {
    // Lista que almacena todas las habitaciones del hotel
    private ArrayList<Habitacion> habitaciones;

    // Lista que almacena todas las reservas realizadas
    private ArrayList<Reserva> reservas;

    // Constructor que recibe el número total de habitaciones a crear
    public Hotel(int totalHabitaciones) {
        habitaciones = new ArrayList<>();
        reservas = new ArrayList<>();

        // Crear las habitaciones y asignarles un número del 1 hasta totalHabitaciones
        for (int i = 1; i <= totalHabitaciones; i++) {
            habitaciones.add(new Habitacion(i));
        }
    }

    // Método para buscar la primera habitación disponible
    public Habitacion buscarHabitacionDisponible() {
        for (Habitacion h : habitaciones) {
            if (h.estaDisponible()) {
                return h; // Retorna la primera habitación libre encontrada
            }
        }
        return null; // Si no hay habitaciones disponibles, retorna null
    }

    // Método para crear una nueva reserva si hay una habitación libre
    public Reserva crearReserva(String cliente) {
        Habitacion libre = buscarHabitacionDisponible();
        if (libre != null) {
            Reserva reserva = new Reserva(cliente, libre); // Se reserva la habitación
            reservas.add(reserva); // Se añade a la lista de reservas
            return reserva;
        }
        return null; // No se pudo crear la reserva porque no hay habitaciones disponibles
    }

    // Método para consultar si una habitación específica está disponible
    public boolean consultarDisponibilidad(int numeroHabitacion) {
        for (Habitacion h : habitaciones) {
            if (h.getNumero() == numeroHabitacion) {
                return h.estaDisponible(); // Retorna true si está disponible
            }
        }
        return false; // Si no se encuentra la habitación, o está ocupada
    }
}