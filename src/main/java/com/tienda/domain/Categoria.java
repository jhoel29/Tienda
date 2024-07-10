package com.tienda.domain;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data //Crea los set y get automaticamente, ahorra codigo
@Entity
@Table(name="categoria")

public class Categoria implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;
    private String descripcion;
    private String rutaImagen; //Hibernate lo transforma en ruta_imagen
    private boolean activo;

    public Categoria() {
    }

    public Categoria(String desciption, String rutaImagen, boolean activo) {
        this.descripcion = desciption;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
    }
}
