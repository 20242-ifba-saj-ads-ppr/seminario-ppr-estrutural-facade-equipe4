public class Main {
    public static void main(String[] args) {
        ReservaHotelFacade hotel = new ReservaHotelFacade();
        hotel.realizarReserva("Suíte Presidencial", "2023-12-25", 1500.00, "cliente@email.com");
    }
}
