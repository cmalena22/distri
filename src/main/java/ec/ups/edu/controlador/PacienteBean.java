package ec.ups.edu.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ec.ups.edu.ejb.PacienteFacade;
import ec.ups.edu.modelo.Paciente;

@Named
@SessionScoped
public class PacienteBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private PacienteFacade ejbPacienteCabecera;
	private String cedula;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String direccion;
	private List<Paciente>listPaciente;
	
	
	@PostConstruct
	public void init() {	
		listPaciente=ejbPacienteCabecera.findAll();
	}
	public List<Paciente> getListPaciente() {
		return listPaciente;
	}

	public void setListPaciente(List<Paciente> listPaciente) {
		this.listPaciente = listPaciente;
	}

	
	public PacienteFacade getEjbPacienteCabecera() {
		return ejbPacienteCabecera;
	}
	public void setEjbPacienteCabecera(PacienteFacade ejbPacienteCabecera) {
		this.ejbPacienteCabecera = ejbPacienteCabecera;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public Paciente registrarPacientes() {
		System.out.println("cedula"+this.cedula);
		System.out.println("nombre"+this.nombre);
		System.out.println("apellidos"+this.apellidos);
		System.out.println("telefono"+this.telefono);
		System.out.println("direccion"+this.direccion);
		Paciente paciente= new Paciente(this.cedula,this.nombre,this.apellidos,this.telefono,this.direccion);
		ejbPacienteCabecera.create(paciente);
		return null;		
	}
	
	
}
