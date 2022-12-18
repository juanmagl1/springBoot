package com.jacaranda.primerSpring.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jacaranda.primerSpring.model.Student;

@Service
public class StudentService {
	private List<Student>lista;

	public StudentService() {
		super();
		lista=new ArrayList<Student>();
		lista.add(new Student("Inma","Olias",25));
		lista.add(new Student("Juanma","Garcia",25));
		lista.add(new Student("Javi","Guarro",25));
		lista.add(new Student("Rafe","Tesorero",26));
	}

	public List<Student> getStudents() {
		return lista;
	}
	public void update(Student o){
		int pos=lista.indexOf(o);
		lista.set(pos, o);
	}

	public boolean add(Student e) {
		return lista.add(e);
	}

	public Student get(String nombre,String apellido) {
		boolean encontrado=false;
		Student resultado=null;
		Iterator<Student>iterator=lista.iterator();
		while (iterator.hasNext()&&!encontrado) {
			resultado=iterator.next();
			if (resultado.getName().equals(nombre)&&resultado.getSurname().equals(apellido)) {
				encontrado=true;
			}
		}
		if (encontrado) {
			return resultado;
		}else {
			return null;
		}
	}

	public boolean remove(Student o) {
		return lista.remove(o);
	}
	
	

}
