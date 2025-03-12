public class ReservaHotelFacade {
     private Disponibilidade disponibilidade;
    private Reserva reserva;
    private Pagamento pagamento;
    private Confirmacao confirmacao;

    public ReservaHotelFacade() {
        this.disponibilidade = new Disponibilidade();
        this.reserva = new Reserva();
        this.pagamento = new Pagamento();
        this.confirmacao = new Confirmacao();
    }
    public void realizarReserva(String tipoQuarto, String data, double valor, String email) {
        System.out.println("Iniciando processo de reserva...");
        if (disponibilidade.verificarDisponibilidade(tipoQuarto, data)) {
            reserva.fazerReserva(tipoQuarto, data);

            if (pagamento.processarPagamento(valor)) {
                confirmacao.enviarConfirmacao(email);
                System.out.println("Reserva realizada com sucesso!");
            } else {
                System.out.println("Falha no processamento do pagamento.");
            }
        } else {
            System.out.println("Quarto indisponível para a data selecionada.");
        }
    }
}
