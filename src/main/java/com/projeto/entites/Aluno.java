package com.projeto.entites;

	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;

	import jakarta.validation.constraints.NotNull;

	@Entity
	@Table (name = "Aluno")
	public class Aluno {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idAluno;
		
		@NotNull
		private String nome;
		
		@NotNull
		private String cpf;
		
		@NotNull
		private String rg;
		
		@NotNull
		private String endereco;

		public Long getIdAluno() {
			return idAluno;
		}

		public void setIdAluno(Long idAluno) {
			this.idAluno = idAluno;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public String getRg() {
			return rg;
		}

		public void setRg(String rg) {
			this.rg = rg;
		}
		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
	}