package org.springframework.samples.petclinic.rest;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;

import org.springframework.samples.petclinic.model.Oferta;
import org.springframework.samples.petclinic.model.Oferta;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Visit;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class JacksonCustomOfertaSerializer extends StdSerializer<Oferta> {

	public JacksonCustomOfertaSerializer() {
		this(null);
	}

	public JacksonCustomOfertaSerializer(Class<Oferta> t) {
		super(t);
	}

	@Override
	public void serialize(Oferta oferta, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		Format formatter = new SimpleDateFormat("yyyy/MM/dd");
		jgen.writeStartObject();
		if (oferta.getId() == null) {
			jgen.writeNullField("id");
		} else {
			jgen.writeNumberField("id", oferta.getId());
		}

		jgen.writeStringField("titulo", oferta.getTitulo());
		jgen.writeStringField("detalle", oferta.getDetalle());
		jgen.writeNumberField("descuento", oferta.getDescuento());
		jgen.writeStringField("fechaCad", formatter.format(oferta.getFechaCad()));
		// write pets array
		jgen.writeEndObject(); // oferta
	}

}
