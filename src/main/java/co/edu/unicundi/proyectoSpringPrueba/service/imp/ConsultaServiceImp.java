package co.edu.unicundi.proyectoSpringPrueba.service.imp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import co.edu.unicundi.proyectoSpringPrueba.entity.Consulta;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;
import co.edu.unicundi.proyectoSpringPrueba.repository.IConsultaRepo;
import co.edu.unicundi.proyectoSpringPrueba.service.IconsultaService;
import org.springframework.data.domain.Sort;

@Service
public class ConsultaServiceImp implements IconsultaService {

	@Autowired
	private IConsultaRepo repo;
	
	@Override
	public Consulta retornarPorId(Integer id) throws ModelNotFoundException {
		Consulta consulta = repo.findById(id).orElseThrow(
				() -> new ModelNotFoundException("Consulta no encontrada"));
		//consulta.setDetalleConsulta(null);
		//consulta.getDetalleConsulta().clear();
		return consulta;
	}

	@Override
	public List<Consulta> retornar() {
		List<Consulta> listaConsulta = repo.findAll();
		for (Consulta consulta : listaConsulta) {
			consulta.setDetalleConsulta(null);
		}
		return listaConsulta;
	}

	@Override
	public void guardar(Consulta consulta) {
		consulta.setId(null);
		if(consulta.getDetalleConsulta() != null) {
			consulta.getDetalleConsulta().forEach(det -> {
				det.setConsulta(consulta);
			});
		}
		repo.save(consulta);
	}

	@Override
	public void editar(Consulta consulta) throws ModelNotFoundException {
		Consulta con = this.retornarPorId(consulta.getId());
		con.setNombreDoctor(consulta.getNombreDoctor());
		con.setFecha(consulta.getFecha());
		repo.save(con);
	}

	@Override
	public void eliminar(Integer id) throws ModelNotFoundException {
		//Cambiar por consulta mas optima
		this.retornarPorId(id);
		repo.deleteById(id);
	}
	

	@Override
	public Page<Consulta> retornarPaginado(Integer page, Integer size) {
		return repo.findAll(PageRequest.of(page, size));
	}

	@Override
	public Page<Consulta> retornarPaginadoOrdenado(Integer page, Integer size, String ordenar) {
		return  repo.findAll( PageRequest.of(page, size, Sort.by(ordenar).ascending()) );
	}

	@Override
	public List<Consulta> buscarConsultaOrdenar(String ordenar) {
		return this.repo.buscarConsultaOrdenar(Sort.by(ordenar).ascending());
	}

	@Override
	public List<Consulta> retornarDoctorFecha(String nombreDoctor, String fecha) {
		System.out.println("nombreDoctor :" +nombreDoctor);
		System.out.println("fecha :" +fecha);
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechadate = null;
		try {
			fechadate = formato.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return repo.findBynombreDoctorAndFecha(nombreDoctor,fechadate);
	}

	@Override
	public List<Consulta> detalleConsultaTratamiento(String tratamiento) {
		return repo.findBydetalleConsulta_tratamiento(tratamiento);
	}

	

	

}
