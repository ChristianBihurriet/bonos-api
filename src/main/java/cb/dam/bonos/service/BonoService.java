package cb.dam.bonos.service;


import cb.dam.bonos.model.Bono;
import cb.dam.bonos.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BonoService {

    Bono crearBono(Bono bono, User user);

    List<Bono> obtenerBonos();

    Bono obtenerBonoPorId(Integer id);

    Bono actualizarBono(Integer id, Bono bono);

    void eliminarBono(Integer id);

    List<Bono> obtenerBonosPorUsuario(User user);
}
