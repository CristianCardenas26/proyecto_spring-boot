import org.springframework.stereotype.Service;
package evidencias.M2.Actividad-04;

public class MessageService 
{
 private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public String showMessage() {
        return repository.getMessage();
    }   
}
