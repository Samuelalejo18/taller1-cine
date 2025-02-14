package controller.DAO;

import java.sql.SQLException;
import java.util.List;

public interface IGenericDAO<T> {

    List<T> listarTodos() throws SQLException;
   boolean buscarPorId(T entidad) throws SQLException;

    boolean agregar(T entidad) throws SQLException;

    boolean modificar(T entidad) throws Exception;

    boolean eliminar(T entidad) throws SQLException;
}