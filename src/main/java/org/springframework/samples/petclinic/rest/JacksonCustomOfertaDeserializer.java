package org.springframework.samples.petclinic.rest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.samples.petclinic.model.Oferta;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class JacksonCustomOfertaDeserializer extends StdDeserializer<Oferta> {
	
	public JacksonCustomOfertaDeserializer(){
		this(null);
	}

	public JacksonCustomOfertaDeserializer(Class<Oferta> t) {
		super(t);
	}

	@Override
	public Oferta deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
		JsonNode node = parser.getCodec().readTree(parser);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Oferta oferta = new Oferta();
		Integer id = node.get("id").asInt();
		Date fechaCadFormatted = null;
		String titulo = node.get("titulo").asText(null);
		String detalle = node.get("detalle").asText(null);
		Integer descuento = node.get("descuento").asInt();
		String fechaCad = node.get("fechaCad").asText(null);
		try {
			fechaCadFormatted = formatter.parse(fechaCad);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new IOException(e);
		}

		if (!(id == 0)) {
			oferta.setId(id);
		}
        oferta.setTitulo(titulo);
        oferta.setDetalle(detalle);
        oferta.setDescuento(descuento);
        oferta.setFechaCad(fechaCadFormatted);
		return oferta;
	}

}