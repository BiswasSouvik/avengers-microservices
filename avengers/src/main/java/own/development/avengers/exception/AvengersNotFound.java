package own.development.avengers.exception;

public class AvengersNotFound extends Throwable {
    public AvengersNotFound(Long id) {
        super("No Avenger found with this ID : "+id);
    }

    public AvengersNotFound() {
        super("No Avenger exists");
    }
}
