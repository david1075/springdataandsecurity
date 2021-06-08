package co.edu.unicundi.proyectoSpringPrueba.service.imp;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import co.edu.unicundi.proyectoSpringPrueba.entity.Medico;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;
import co.edu.unicundi.proyectoSpringPrueba.repository.IMedicoRepo;
import co.edu.unicundi.proyectoSpringPrueba.service.IMedicoService;

@Service
public class MedicoServiceImp implements IMedicoService {

	@Autowired
	private IMedicoRepo repo;
	
	@Override
	public Medico retornarPorId(Integer id) throws ModelNotFoundException {
		Medico medico = repo.findById(id).orElseThrow(
				() -> new ModelNotFoundException("Medico no encontrado"));
		return medico;
	}

	@Override
	public Page<Medico> retornarPaginado(Integer page, Integer size) {
		return repo.findAll(PageRequest.of(page, size));
	}

	@Override
	public Page<Medico> retornarPaginadoOrdenado(Integer page, Integer size, String ordenar) {
		return repo.findAll(PageRequest.of(page, size, Sort.by(ordenar).ascending()));
	}

	@Override
	public void guardar(Medico medico) {
		medico.getDireccion().setMedico(medico);
		repo.save(medico);
	}

	@Override
	public void editar(Medico medico) throws ModelNotFoundException {
		Medico med = retornarPorId(medico.getId());
		med.setNombre(medico.getNombre());
		med.setApellido(medico.getApellido());
		med.setCorreo(medico.getCorreo());
		med.getDireccion().setBarrio(medico.getDireccion().getBarrio());
		med.getDireccion().setCiudad(medico.getDireccion().getCiudad());
		med.getDireccion().setPais(medico.getDireccion().getPais());
		med.getDireccion().setDetalle(medico.getDireccion().getDetalle());
		
		repo.save(med);
	}

	@Override
	public void eliminar(Integer id) throws ModelNotFoundException {
		if(cantidadObtenida(id) > 0)
			repo.deleteById(id);
		else
			 throw new ModelNotFoundException("Medico no encontrado");	
	}
	
	private Integer cantidadObtenida(Integer id) {
		BigInteger cantidad = (BigInteger) this.repo.cantidadObtenida(id);
		return cantidad.intValue();
	}

	//metodo paginado con objeto de tipo Pageable y busqueda por nombramiento
	@Override
	public Page<Medico> retornarnombremedico(String nombre, Integer page, Integer size) throws ModelNotFoundException {
		Page <Medico> medico =  repo.findBynombre(nombre, PageRequest.of(page, size, Sort.by("nombre").ascending()));
		if(medico != null) {
			return medico;
		}else
			throw new ModelNotFoundException("Medico no encontrado");
	}

	@Override
	public Page<Medico> retornarApellido(String Apellido, Integer page, Integer size) {
		return repo.findByApellidoIgnoreCaseOrderByNombreAsc(Apellido, PageRequest.of(page, size));
	}

	@Override
	public Medico retornarCorreo(String correo) {
		return repo.findBycorreo(correo);
	}
	
	//TENER EN CUENTA  no se pueden hacer sort a elementos dentro de direccion
	@Override
	public Medico RetornarDireccionDetalle(String detalle) {
		return repo.findByDireccion_detalle(detalle);
	}

	@Override
	public Page<Medico> retornarDireccionCiudad(String ciudad, Integer page, Integer size) {
		return repo.findByDireccion_ciudadIgnoreCaseOrderByDireccion_barrioAsc(ciudad, PageRequest.of(page, size));
	}

	@Override
	public Page<Medico> retornarDireccionPais(String pais, Integer page, Integer size) {
		return repo.findByDireccion_paisIgnoreCaseOrderByDireccion_ciudadAsc(pais, PageRequest.of(page, size));
	}

	@Override
	public Page<Medico> retornarDireccionBarrio(String barrio, Integer page, Integer size) {
		return repo.findByDireccion_barrioIgnoreCaseOrderByNombreAsc(barrio, PageRequest.of(page, size));
	}


		
}


