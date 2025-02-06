package controller;

import model.Cine;

import java.util.List;

public interface IGenericDAO<T> {

    List<T> listarTodos();

    T buscarPorId(T entidad);

    boolean agregar(T entidad);

    boolean modificar(T entidad);

    boolean eliminar(int id);
}