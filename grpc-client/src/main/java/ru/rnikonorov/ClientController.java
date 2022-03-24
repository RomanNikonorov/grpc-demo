package ru.rnikonorov;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rnikonorov.grpcclient.ClientService;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello(@RequestParam("name") final String name) {
        return ResponseEntity.ok(clientService.sayHello(name));
    }
}
