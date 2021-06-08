package co.edu.unicundi.proyectoSpringPrueba.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import co.edu.unicundi.proyectoSpringPrueba.entity.Consulta;
import co.edu.unicundi.proyectoSpringPrueba.entity.DetalleConsulta;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;
import co.edu.unicundi.proyectoSpringPrueba.repository.IDetalleConsultaRepo;
import co.edu.unicundi.proyectoSpringPrueba.service.IDetalleConsultaService;


@Service
public class DetalleConsultaServiceImp implements IDetalleConsultaService{
	
	@Autowired
	private IDetalleConsultaRepo repo;
	
	@Autowired
	private ConsultaServiceImp consulta;

	@Override
	public DetalleConsulta retornarPorId(int id) throws ModelNotFoundException {
		DetalleConsulta detalleConsulta = repo.findById(id).orElseThrow(
				() -> new ModelNotFoundException("Consulta no encontrada"));
		return detalleConsulta;
	}
	

	@Override
	public List<DetalleConsulta> retornar() {
		List<DetalleConsulta> listaDetalle = repo.findAll();
		return listaDetalle;
	}

	@Override
	public void guardar(DetalleConsulta detalleConsulta, Integer id)throws  ModelNotFoundException {
		Consulta consultar = consulta.retornarPorId(id);
		detalleConsulta.setId(null);
		detalleConsulta.setConsulta(consultar);
		repo.save(detalleConsulta);
	}
		
		
	

	@Override
	public void editar(DetalleConsulta detalleConsulta, Integer id) throws ModelNotFoundException {
		Consulta consultar = consulta.retornarPorId(id);
		DetalleConsulta detalle = retornarPorId(detalleConsulta.getId());
		detalle.setDiagnostico(detalleConsulta.getDiagnostico());
		detalle.setTratamiento(detalleConsulta.getTratamiento());
		detalle.setConsulta(consultar);
		repo.save(detalle);
		
		
		
	}

	@Override
	public void eliminar(Integer id) throws ModelNotFoundException {
		DetalleConsulta detalle = retornarPorId(id);
		repo.delete(detalle);
		
	}


	@Override
	public List<DetalleConsulta> buscarDConsultaOrdenar(String ordenar) {
		return this.repo.buscarDConsultaOrdenar(Sort.by(ordenar).ascending());
	}


	@Override
	public Page<DetalleConsulta> retornarDPaginado(Integer page, Integer size) {
		return repo.findAll(PageRequest.of(page, size));
	}


	@Override
	public Page<DetalleConsulta> retornarDPaginadoOrdenado(Integer page, Integer size, String ordenar) {
		return  repo.findAll( PageRequest.of(page, size, Sort.by(ordenar).ascending()) );
	}


	@Override
	public List<DetalleConsulta> retornarTratamientoDiagnostico(String tratamiento, String diagnostico) {
		System.out.println("tratamiento :" +tratamiento);
		System.out.println("diagnostico :" +diagnostico);
		return repo.findByTratamientoAndDiagnostico(tratamiento, diagnostico);
	}


	@Override
	public List<DetalleConsulta> retornarDiagnostico(String diagnostico) {
		return repo.findByDiagnosticoOrderByConsultaDesc(diagnostico);
	}


	@Override
	public List<DetalleConsulta> retornarNombreDoctor(String nombreDoctor) {
		return repo.findByconsulta_nombreDoctor(nombreDoctor);
	}

	
}
