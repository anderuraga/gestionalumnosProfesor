package com.ipartek.formacion.service;

import com.ipartek.formacion.pojo.Departamento;
import com.ipartek.formacion.pojo.DepartamentoEmpleados;

public class Util {
	
	
	  private static final int DNI_LONGITUD = 9;
	  private static final int DNI_DIVISOR = 23;
	  private static EmpleadoService eService = EmpleadoServiceImp.getInstance();
	  private static DepartamentoService dService = DepartamentoServiceImp.getInstance();

	
	//	empleado.setDepartamento_empleado(Util.parseDepartamentoEmpleados(rs.getInt("departamento_empleado")));


	public static Departamento parseTipo(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}


	public static Departamento parseDepartamento(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
