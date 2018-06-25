package br.alu.thiago.caixa.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.alu.thiago.caixa.domain.Fabricante;
import br.alu.thiago.caixa.domain.Fachada;

@FacesConverter("fabricanteConverter")
public class FabricanteConverter implements Converter {

	private Fachada fachada;

	public FabricanteConverter() {

		this.fachada = Fachada.getInstancia();
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent componente, String valor) {

		try {

			Long codigo = Long.parseLong(valor);

			Fabricante fabricante = this.fachada.buscarPorCodigoFabricante(codigo);

			return fabricante;

		} catch (Exception re) {

			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent componente, Object objeto) {

		try {

			
			Fabricante fabricante = (Fabricante) objeto;

			Long codigo = fabricante.getCodigo();
			
			return codigo.toString();

		} catch (Exception re) {

			return null;
		}

	}

}
