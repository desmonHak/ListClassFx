package com.david.listclassfx;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DirClass {
    private Class<?> clazz;
    private String methods;
    private String constructors;
    private String atributos;

    public DirClass(String name) throws ClassNotFoundException {
        this.clazz = Class.forName(name);
        this.methods = convertArrayToString(clazz.getMethods());
        this.constructors = convertArrayToString(clazz.getConstructors());
        this.atributos = convertArrayToString(clazz.getFields());
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    // Getter usado por el PropertyValueFactory en el controlador.
    public String getConstructors() {
        return constructors;
    }

    public void setConstructors(String constructors) {
        this.constructors = constructors;
    }

    // Para que el PropertyValueFactory encuentre el getter correspondiente a la propiedad "methodsAsString"
    public String getMethodsAsString() {
        return methods;
    }

    public void setMethods(String methods) {
        this.methods = methods;
    }

    public String getAtributos() {
        return atributos;
    }

    public void setAtributos(String atributos) {
        this.atributos = atributos;
    }

    // Método auxiliar para convertir cualquier arreglo de objetos a una cadena con un salto de línea entre elementos.
    private String convertArrayToString(Object[] array) {
        return Arrays.stream(array)
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }
}
