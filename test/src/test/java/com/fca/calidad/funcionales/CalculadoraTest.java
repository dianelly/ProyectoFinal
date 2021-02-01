package com.fca.calidad.funcionales;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.fca.calidad.test.Calculadora;

public class CalculadoraTest {
	private Calculadora cal;
	
	@Before
	public void inicializar1() {
		cal =new Calculadora();
	}

	@Test
	public void sumartest() {
		//ejercicio del codigo
		float resultadoejecucion = cal.suma(2, 2);
		float resultadoEsperado = 4.0f;
		// fail
		assertEquals(resultadoEsperado,resultadoejecucion,0.01);
}public void restatest() {
	//ejercicio del codigo
	float resultadoejecucion = cal.resta(5, 2);
	float resultadoEsperado = 4.0f;
	// fail
	assertEquals(resultadoEsperado,resultadoejecucion,0.01);
}
public void multitest() {
	//ejercicio del codigo
	float resultadoejecucion = cal.multiplica(2, 2);
	float resultadoEsperado = 4.0f;
	// fail
	assertEquals(resultadoEsperado,resultadoejecucion,0.01);
}
public void dividitest() {
	//ejercicio del codigo
	float resultadoejecucion = cal.divide(10, 2);
	float resultadoEsperado = 4.0f;
	// fail
	assertEquals(resultadoEsperado,resultadoejecucion,0.01);
}

}
