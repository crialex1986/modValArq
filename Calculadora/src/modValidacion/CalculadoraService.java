package modValidacion;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/Calculator")

public class CalculadoraService {

	@Context
	private UriInfo context;

	@GET
	@Path("/add/{numeros:[0-9/]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public String add(@PathParam("numeros") String numeros) {

		org.json.JSONObject obj = new org.json.JSONObject();

		try {

			System.out.println(numeros);

			String[] valoresSuma = numeros.split("/");
			
			obj.put("Numeros_Ingresados", valoresSuma);

			if (valoresSuma.length >= 2) {
				Double resultado = 0.0;

				for (String valor : valoresSuma) {
										
					resultado += Double.valueOf(valor);
				}
				obj.put("resultado_Suma", resultado);
			} else {
				obj.put("resultado_Resta", "Para usar la operación debe tener al menos 2 números");
			}
		} catch (Exception e) {
			obj.put("result", "Alguno de los valores enviados no es un número");
		}
		return obj.toString();
	}

	@GET
	@Path("/subs/{numeros:[0-9/]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public String subs(@PathParam("numeros") String numeros) {

		org.json.JSONObject obj = new org.json.JSONObject();

		try {

			System.out.println(numeros);

			String[] valoresSuma = numeros.split("/");
			
			obj.put("Numeros_Ingresados", valoresSuma);

			if (valoresSuma.length >= 2) {
				Double resultado = Double.valueOf(valoresSuma[0]);

				for (int i = 1; i < valoresSuma.length; i++) {

					resultado -= Double.valueOf(valoresSuma[i]);
				}
				obj.put("resultado_Resta", resultado);
			} else {
				obj.put("resultado_Resta", "Para usar la operación debe tener al menos 2 números");
			}
		} catch (Exception e) {
			obj.put("resultado_Resta", "Alguno de los valores enviados no es un número");
		}
		return obj.toString();
	}

	@GET
	@Path("/mult/{numeros:[0-9/]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public String mult(@PathParam("numeros") String numeros) {

		org.json.JSONObject obj = new org.json.JSONObject();

		try {

			System.out.println(numeros);

			String[] valoresSuma = numeros.split("/");
			
			obj.put("Numeros_Ingresados", valoresSuma);

			if (valoresSuma.length >= 2) {
				Double resultado = 1.0;

				for (String valor : valoresSuma) {

					resultado *= Double.valueOf(valor);
				}
				obj.put("resultado_multiplicación", resultado);
			} else {
				obj.put("resultado_multiplicación", "Para usar la operación debe tener al menos 2 números");
			}

		} catch (Exception e) {
			obj.put("resultado_multiplicación", "Alguno de los valores enviados no es un número");
		}
		return obj.toString();
	}

	@GET
	@Path("/div/{numeros:[0-9/]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public String div(@PathParam("numeros") String numeros) {

		org.json.JSONObject obj = new org.json.JSONObject();

		try {

			System.out.println(numeros);

			String[] valoresSuma = numeros.split("/");
			
			obj.put("Numeros_Ingresados", valoresSuma);

			if (valoresSuma.length >= 2) {
				Double resultado = Double.valueOf(valoresSuma[0]);
				Boolean error = false;

				for (int i = 1; i < valoresSuma.length; i++) {

					if (Double.valueOf(valoresSuma[i]) == 0) {
						error = true;
						obj.put("resultado_División", "Alguno de los números es igual 0");
						break;
					} else {
						resultado /= Double.valueOf(valoresSuma[i]);
					}
				}
				if (!error)
					obj.put("resultado_DivisiÃ³n", resultado);
			} else {
				obj.put("resultado_División", "Para usar la operación debe tener al menos 2 números");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			obj.put("resultado_División", "Alguno de los valores enviados no es un número");
		}
		return obj.toString();
	}
}