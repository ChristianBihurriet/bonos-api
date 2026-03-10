package cb.dam.bonos.controller;

import cb.dam.bonos.model.Bono;
import cb.dam.bonos.model.User;
import cb.dam.bonos.service.BonoService;
import cb.dam.bonos.service.BonoServiceImpl;
import cb.dam.bonos.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.method.P;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bonos")
@RequiredArgsConstructor
public class BonoController {
    private final BonoServiceImpl bonoService;
    private final UserServiceImpl userService;

    @PostMapping
    public Bono crearBono(@RequestBody Bono bono, Authentication authentication) {

        String username = authentication.getName();

        User user = userService.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return bonoService.crearBono(bono, user);
    }

    @GetMapping
    public List<Bono> obtenerBonos() {
        return bonoService.obtenerBonos();
    }

    @GetMapping("/{id}")
    public Bono obtenerBono(@PathVariable Integer id) {
        return bonoService.obtenerBonoPorId(id);
    }

    @PutMapping("/{id}")
    public Bono actualizarBono(@PathVariable Integer id, @RequestBody Bono bono) {
        return bonoService.actualizarBono(id, bono);
    }

    @DeleteMapping("/{id}")
    public void eliminarBono(@PathVariable Integer id) {
        bonoService.eliminarBono(id);
    }
}
