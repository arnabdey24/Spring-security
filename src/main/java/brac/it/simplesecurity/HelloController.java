package brac.it.simplesecurity;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/")
  public String hello(HttpServletRequest request) {
    return "Hello World "+request.getSession().getId();
  }

  @PostMapping("/hellos")
  public List<String> hellos() {
    return List.of("Hello", "Hi");
  }

}
