package co.edu.unicundi.proyectoSpringPrueba.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicundi.proyectoSpringPrueba.entity.Consulta;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;
import co.edu.unicundi.proyectoSpringPrueba.repository.IConsultaRepo;

@Service
public class ConsultaServiceImp implements IConsultaService{

	@Autowired
	private IConsultaRepo repo;
	
	@Override
	public Consulta retornarPorId(int id) throws ModelNotFoundException {
		Consulta consulta = repo.findById(id).orElseThrow(
				() -> new ModelNotFoundException("Cosnulta no encontrada"));
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

}
