package ec.ups.edu.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.ups.edu.modelo.Paciente;

@Stateless
public class PacienteFacade  extends AbstractFacade<Paciente>{
//	@PersistenceContext(unitName = "IzaCinthiaExamen")
	@PersistenceContext(unitName = "demoappdockerPersistenceUnit")
    private EntityManager em;
    
    public  PacienteFacade() {
	super(Paciente.class);
    }    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}