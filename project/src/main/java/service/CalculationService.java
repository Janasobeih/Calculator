package service;

import java.util.*;
import javax.*;
import javax.ejb.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import ejbs.Calculation;
import ejbs.Response;

@Stateless
@Path("Calculation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class CalculationService 
{
	Response r=new Response();
	
	@PersistenceContext(unitName = "calculator")
	private EntityManager entityManager;

	@POST
	@Path("calculate")
	public Response Calculate(Calculation c)
	{
		entityManager.persist(c);
		String operation = c.getOperation();
		float N1 = c.getNumber1();
		float N2 = c.getNumber2();
		if (operation.equals("+")) 
		{
			r.Result = N1 + N2;
			c.setResult(r.Result);
			return r;
		} else if (operation.equals("-")) {
			r.Result = N1 - N2;
			c.setResult(r.Result);
			return r;
		} else if (operation.equals("/")) {
			r.Result = N1 / N2;
			c.setResult(r.Result);
			return r;
		} else if (operation.equals("*")) {
			r.Result = N1 * N2;
			c.setResult(r.Result);
			return r;
		}
		else 
		{
			throw new IllegalArgumentException("Invalid");
		}
	}

	@GET
	@Path("Calculations")
	public List<Calculation> getCalculations() {
		TypedQuery<Calculation> q = entityManager.createQuery("SELECT c FROM Calculation c", Calculation.class);
		return q.getResultList();
	}
}
