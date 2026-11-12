import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
package evidencias.M2.Actividad-04;

public class MessageController 
{
 private final MessageService service;

    }

    @GetMapping("/mensaje")
    public String getMessage() {
        return service.showMessage();
    }   
}
