package org.springframework.samples.petclinic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.rest.JacksonCustomOfertaDeserializer;
import org.springframework.samples.petclinic.rest.JacksonCustomOfertaSerializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "ofertas")
@JsonSerialize(using = JacksonCustomOfertaSerializer.class)
@JsonDeserialize(using = JacksonCustomOfertaDeserializer.class)
public class Oferta extends NamedEntity{
	
	@Column(name = "titulo")
    @NotEmpty
    private String titulo;

    @Column(name = "detalle")
    @NotEmpty
    private String detalle;

    @Column(name = "descuento")
    @NotEmpty
    @Digits(fraction = 0, integer = 3)
    @Size(min = 3, max = 50)
    private Integer descuento;
    
    @Column(name = "fechaCad")
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern= "dd/mm/yyyy")
    private Date fechaCad;
    
    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getDetalle() {
        return this.detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    public Integer getDescuento() {
        return this.descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

	public Date getFechaCad() {
		return fechaCad;
	}

	public void setFechaCad(Date fechaCad) {
		this.fechaCad = fechaCad;
	}
}
