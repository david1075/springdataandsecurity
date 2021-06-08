package co.edu.unicundi.proyectoSpringPrueba.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import co.edu.unicundi.proyectoSpringPrueba.dto.ConsultaExamenDto;
import co.edu.unicundi.proyectoSpringPrueba.entity.Consulta;
import co.edu.unicundi.proyectoSpringPrueba.entity.ConsultaExamen;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;
import co.edu.unicundi.proyectoSpringPrueba.repository.IConsultaExamenRepo;
import co.edu.unicundi.proyectoSpringPrueba.service.IConsultaExamenService;
import co.edu.unicundi.proyectoSpringPrueba.view.DetalleExamenView;

@Service
public class ConsultaExamenServiceImp implements IConsultaExamenService {
	

	@Autowired
	private IConsultaExamenRepo repo;
	
	private ConsultaExamenDto consultaExamen;

	@Override
	public ConsultaExamen retornarPorId(Integer id) throws ModelNotFoundException {
		// tiene llave compuesta, no se puede
		return null;

	}

	@Override
	public Page<ConsultaExamen> retornarPaginado(Integer page, Integer size) {
		return repo.findAll(PageRequest.of(page, size));
	}

	@Override
	public Page<ConsultaExamen> retornarPaginadoOrdenado(Integer page, Integer size, String ordenar) {
		return  repo.findAll( PageRequest.of(page, size, Sort.by(ordenar).ascending()) );
	}

	@Override
	public void guardar(ConsultaExamen entity) {
		// debe ir en cascada, crear uno a muchos en consulta, no funciona con doble relacion ya que existen 2 ids
		System.out.println(entity.getConsulta().getId());
		System.out.println(entity.getExamen().getId());
		System.out.println(entity.getInfoAdicional());
		repo.save(entity);
	}

	@Override
	public void editar(ConsultaExamen entity) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer id) throws ModelNotFoundException {
		// necesita dos ids para eliminar 
		
	}

	@Override
	public void guardarNativo(ConsultaExamen consultaExamen) {
		repo.guardar(consultaExamen.getConsulta().getId(), consultaExamen.getExamen().getId(), consultaExamen.getInfoAdicional());
	}

	@Override
	public ConsultaExamenDto listarPorIdCosnulta(Integer idConsulta) throws ModelNotFoundException {
			consultaExamen.setConsulta((Consulta)repo.consulta(idConsulta));
			System.out.println(consultaExamen.getExamenes());
			consultaExamen.setExamenes(repo.listarExamenes(idConsulta));
			consultaExamen.setInfoadicional(repo.listarInfoAdicional(idConsulta));
		return consultaExamen;
	}

	@Override
	public Page<ConsultaExamen> listarPorIdCosnultaPaginado(Integer id, Integer page, Integer size) {
		return repo.findByConsulta_Id(id, PageRequest.of(page, size));
	}

	@Override
	public List<DetalleExamenView> listarExamenesPorIdConsulta(Integer idConsulta)  {
		return repo.listarExamenesPorIdConsulta(idConsulta);
	}


}
