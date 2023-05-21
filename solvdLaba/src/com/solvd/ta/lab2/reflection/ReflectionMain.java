package com.solvd.ta.lab2.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReflectionMain {
	public static void main(String[] args) throws ClassNotFoundException {
		final Logger LOGGER = LogManager.getLogger(ReflectionMain.class);
		Class classM = Class.forName("com.solvd.ta.lab2.Member");
		Field[] fields = classM.getDeclaredFields();
		Constructor[] constructors = classM.getDeclaredConstructors();
		Method[] methods = classM.getDeclaredMethods();

		LOGGER.info(String.format("%-15s %-50s %-30s", "Field", "Type", "Modifiers"));
		for (Field f : fields) {
			LOGGER.info(
					String.format("%-15s %-50s %-30s", f.getName(), f.getType(), Modifier.toString(f.getModifiers())));
		}

		System.out.println();

		LOGGER.info(String.format("%-30s %-50s %-30s", "Constructor", "Parameter Types", "Modifiers"));
		for (Constructor c : constructors) {
			LOGGER.info(String.format("%-30s %-50s %-30s", c.getName(), Arrays.toString(c.getParameterTypes()),
					Modifier.toString(c.getModifiers())));
		}

		System.out.println();

		LOGGER.info(String.format("%-30s %-50s %-35s %-30s", "Method", "Parameter Types", "Return Type", "Modifiers"));
		for (Method m : methods) {
			LOGGER.info(String.format("%-30s %-50s %-35s %-30s", m.getName(), Arrays.toString(m.getParameterTypes()),
					m.getReturnType(), Modifier.toString(m.getModifiers())));
		}

	}
}
