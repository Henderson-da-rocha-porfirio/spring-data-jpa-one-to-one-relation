package com.tuyo.associations.onetoone.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Licenca {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Isso fará termos o mesmo ID em Pessoa e em Licenca.
	private Long id;
	private String type;
	@Temporal(TemporalType.DATE) // Ao utilizarmos o Tipo Date, precisamos marcá-los com a @Temporal de javax.persistence
	private Date validFrom;
	@Temporal(TemporalType.DATE)
	private Date validTo;
	@OneToOne(cascade = CascadeType.ALL) 			// Usando Cascading (efeito cascata) = é o processo de propagação de não-select operations como: insert, delete e update do objeto Pai em associação com o objeto filho.
	@JoinColumn(name="pessoa_id")					// Nós podemos controlar como a propagação acontece e em que nível e sobre que operações usar o elemento Cascade num tipo de relacionamento.
	private Pessoa pessoa; 							// Definindo a associação OneToOne.
													// ALL = todas as operações executadas pelo Pai, o Filho sofrerá as mesmas, ou seja, Todos os efeitos em cascata que Pessoa sofrer, Licenca também sofrerá.
	public Long getId() {							// Por exemplo: se salvarmos nossa Licenca, queremos que Pessoa também seja Salva.
		return id;									// Se atualizarmos Licenca (Update) e se a informação de Pessoa tiver mudado, então, ela será automaticamente atualizada (updated).
	}												// Todas as operações non-select como: insert, delete e update do objeto Pai em associação com o objeto Filho poderão ser realizadas aqui com ALL.
													// @JoinColumn = fala ao hibernate em que coluna será efetuado o Join na tabela Licenca que será usada para buscar, salvar e etc, Pessoa ( pessoa_id [tem que estar exatamente como estar no database] ).
	public void setId(Long id) {					// pessoa_id = fará o join na Tabela Licenca que guarda a Foreign Key da Tabela Pessoa.
		this.id = id;								// Isso é um lado da configuração do relacionamento OneToOne. A outra parte do relacionamento precisa ser feito em Pessoa introduzindo: @OneToOne(mappedBy = "pessoa") no atributo Licenca.
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
