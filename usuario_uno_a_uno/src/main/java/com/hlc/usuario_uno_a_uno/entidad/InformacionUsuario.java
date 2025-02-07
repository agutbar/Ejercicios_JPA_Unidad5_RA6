package com.hlc.usuario_uno_a_uno.entidad;


import com.hlc.usuario_uno_a_uno.entidad.enumerado.Rol;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


    @Entity
    @Table(name = "informacion_usuarios")
    public class InformacionUsuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, length = 100)
        @NotBlank(message = "El email no puede estar vacío")
        @Email(message = "Debe ser un email válido")
        private String email;

        @Column(nullable = false, length = 15)
        @NotBlank(message = "El teléfono no puede estar vacío")
        @Size(min = 8, max = 15, message = "El teléfono debe contener entre 8 y 15 caracteres")
        private String telefono;

        @OneToOne
        @JoinColumn(name = "usuario_id", nullable = false)
        private Usuario usuario; // Esta es la propiedad que debe existir
        
        @Column
        @NotNull(message = "El rol debe ser Admin, User o Manager")
        @Enumerated(EnumType.STRING)
        private Rol rol;
    
        // Constructor vacío
    public InformacionUsuario() {}
    
    // Constructor con parámetros
    public InformacionUsuario(String email, String telefono) {
        this.email = email;
        this.telefono = telefono;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
    
    
}
