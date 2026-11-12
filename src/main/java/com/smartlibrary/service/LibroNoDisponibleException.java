package com.smartlibrary.service;

public class LibroNoDisponibleException extends RuntimeException {

    public LibroNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}
