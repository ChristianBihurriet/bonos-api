package cb.dam.bonos.service;

import cb.dam.bonos.model.Bono;
import cb.dam.bonos.model.User;
import cb.dam.bonos.repository.BonoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BonoServiceImpl implements BonoService{

    private final BonoRepository bonoRepository;

    @Override
    public Bono crearBono(Bono bono, User user) {
        bono.setCreator(user);
        return bonoRepository.save(bono);
    }

    @Override
    public List<Bono> obtenerBonos() {
        return bonoRepository.findAll();
    }

    @Override
    public Bono obtenerBonoPorId(Integer id) {
        return bonoRepository.findById(id).orElseThrow(() -> new RuntimeException("Bono no encontrado"));
    }

    @Override
    public List<Bono> obtenerBonosPorUsuario(User user) {
        return bonoRepository.findByCreator(user);
    }

    @Override
    public Bono actualizarBono(Integer id, Bono bonoActualizado) {
        Bono bono = obtenerBonoPorId(id);

        bono.setServicio(bonoActualizado.getServicio());
        bono.setComprador(bonoActualizado.getComprador());
        bono.setPrecio(bonoActualizado.getPrecio());
        bono.setFechaCompra(bonoActualizado.getFechaCompra());
        bono.setFechaVencimiento(bonoActualizado.getFechaVencimiento());
        bono.setEstado(bonoActualizado.getEstado());

        return bonoRepository.save(bono);
    }
    @Override
    public void eliminarBono(Integer id) {

        Bono bono = obtenerBonoPorId(id);

        bonoRepository.delete(bono);
    }
}
