package com.tuyo.associations.onetoone.entities;

import javax.persistence.*;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Isso fará termos o mesmo ID em Pessoa e em Licenca.
	private Long id;
	private String firstName;
	private String lastName;
	private int age;
	@OneToOne(mappedBy = "pessoa") // Isso é o outro lado da configuração do relacionamento OneToOne. A outra parte do relacionamento precisa ser feito em Licenca introduzindo: @OneToOne(mappedBy = "pessoa") no atributo Licenca.
	private Licenca licenca;   		//@OneToOne(cascade = CascadeType.ALL) + @JoinColumn(name="pessoa_id") no atributo: private Pessoa pessoa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Licenca getLicense() {
		return licenca;
	}

	public void setLicense(Licenca licenca) {
		this.licenca = licenca;
	}

}
