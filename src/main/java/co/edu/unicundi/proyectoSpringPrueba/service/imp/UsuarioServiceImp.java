package co.edu.unicundi.proyectoSpringPrueba.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import co.edu.unicundi.proyectoSpringPrueba.entity.Consulta;
import co.edu.unicundi.proyectoSpringPrueba.entity.Usuario;
import co.edu.unicundi.proyectoSpringPrueba.exception.ModelNotFoundException;
import co.edu.unicundi.proyectoSpringPrueba.repository.IUsuarioRepo;
import co.edu.unicundi.proyectoSpringPrueba.service.IUsuarioService;

@Service	
public class UsuarioServiceImp implements IUsuarioService, UserDetailsService  {

	@Autowired
	private IUsuarioRepo repo;
	

	//@Autowired
	//private BCryptPasswordEncoder bcrypt;		
	
	@Override
	public Consulta retornarPorId(int id) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}	

	@Override
	public Page<Usuario> retornarPaginado(Integer page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Usuario> retornarPaginadoOrdenado(Integer page, Integer size, String ordenar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		//usuario.setClave(bcrypt.encode(usuario.getClave()));
	}

	@Override
	public void editar(Usuario usuario) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cambiarEstado(Integer id) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repo.findOneByNick(username);
		
		if(usuario == null)
			throw new UsernameNotFoundException("----Usuario no encontrado");
		
		if(usuario.isEstado() == false)
		{
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(usuario.getRol().getNombre()));
		
		UserDetails ud = new User(usuario.getNick(), usuario.getClave(), roles);
		return ud;		
	}



}