# Padrão Facade

## Motivação

Em um sistema de reservas de hotel, o cliente precisa interagir com vários subsistemas, como verificar a disponibilidade de quartos, fazer a reserva, processar o pagamento e enviar a confirmação. O padrão Facade simplifica esse processo, fornecendo uma interface única para o cliente realizar uma reserva sem precisar conhecer os detalhes de cada subsistema.

## Participantes

### **ReservaHotelFacade (Facade)**:
- Fornece uma interface simplificada para o cliente.
- No código: Classe `ReservaHotelFacade`.

### **Disponibilidade, Reserva, Pagamento, Confirmacao (Subsistemas)**:
- Classes que realizam operações específicas.
- No código: Classes `Disponibilidade`, `Reserva`, `Pagamento` e `Confirmacao`.

### **Main (Cliente)**:
- Usa a interface simplificada fornecida pela `Facade`.
- No código: Classe `Main`.

## Diagrama UML

```mermaid
classDiagram
    class Disponibilidade {
        +verificarDisponibilidade(String tipoQuarto, String data)
    }

    class Reserva {
        +fazerReserva(String tipoQuarto, String data)
    }

    class Pagamento {
        +processarPagamento(double valor)
    }

    class Confirmacao {
        +enviarConfirmacao(String email)
    }

    class ReservaHotelFacade {
        -Disponibilidade disponibilidade
        -Reserva reserva
        -Pagamento pagamento
        -Confirmacao confirmacao
        +realizarReserva(String tipoQuarto, String data, double valor, String email)
    }

    class Main {
        +main(String[] args)
    }

    ReservaHotelFacade --> Disponibilidade
    ReservaHotelFacade --> Reserva
    ReservaHotelFacade --> Pagamento
    ReservaHotelFacade --> Confirmacao
    Main --> ReservaHotelFacade
