package com.ipartek.formacion.dbms.dao;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import com.ipartek.formacion.dbms.ConexionDB;
import com.ipartek.formacion.pojo.Empleado;
public class EmpleadoDAOImp implements EmpleadoDAO {
	private static final Logger		LOG			= Logger.getLogger(EmpleadoDAOImp.class);
	private static EmpleadoDAOImp	INSTANCE	= null;
	private ConexionDB				myConexion	= null;
	// INSERTAR EMPLEADO
	public Empleado CreateEmpleado(Empleado empleado) {
		Empleado emple = null;
		String sql = "{call InsertEmpleado(?,?,?,?,?,?,?,?,?,?,?)}";
		try {
			CallableStatement cSmt = myConexion.getConexion().prepareCall(sql);
			cSmt.setString("nombre", empleado.getNombre());
			cSmt.setString("apellido", empleado.getApellido());
			cSmt.setDate("date_nacimiento", new Date(empleado.getDate_nacimiento().getTime()));
			cSmt.setDate("date_contratacion", new Date(empleado.getDate_contratacion().getTime()));
			cSmt.setString("num_seg_soc", empleado.getNum_seg_soc());
			cSmt.setString("num_dni", empleado.getNum_dni());
			cSmt.setString("num_cuenta_corriente", empleado.getCuenta_corriente());
			cSmt.setString("direccion", empleado.getDireccion());
			cSmt.setString("localidad", empleado.getLocalidad());
			cSmt.setInt("codigo_postal", empleado.getCodigo_postal());
			cSmt.setInt("pertenece_departamento", empleado.getDepartamento_empleado().getCodigo());
			cSmt.executeUpdate();
			emple = empleado;
			emple.setCodigo(cSmt.getInt("codigo"));
		}
		catch (SQLException e) {
			LOG.fatal(e.getMessage() + " -- Error al insertar empleado");
		}
		finally {
			myConexion.desconectar();
		}
		return emple;
	}
	// FIN INSERTAR EMPLEADO
	
	
	
	
	public List<Empleado> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public Empleado UpdateEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return null;
	}
	public void DeleteEmpleado(int empleado) {
		// TODO Auto-generated method stub
	}
	public Empleado getById(int empleado) {
		// TODO Auto-generated method stub
		return null;
	}
}
