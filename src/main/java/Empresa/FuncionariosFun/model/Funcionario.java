package Empresa.FuncionariosFun.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name = "nome")
    private String nome;

    @Column(nullable = false, name = "data_contratacao")
    private LocalDate dataContratacao;

    @ManyToMany
    @JoinTable(name = "funcionarios_cargos", joinColumns = @JoinColumn(name = "funcionario_id"), inverseJoinColumns = @JoinColumn(name = "cargo_id"))
    private List<Cargo> cargos;

    @Column(nullable = false, name = "salario")
    private double salario;

    public Funcionario() {}

    public Funcionario(String nome, LocalDate dataContratacao, List<Cargo> cargo, double salario) {
        this.nome = nome;
        this.dataContratacao = dataContratacao;
        this.cargos = cargo;
        this.salario = salario;
    }

    //getters e setters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getDataContratacao() { return dataContratacao; }
    public void setDataContratacao(LocalDate dataContratacao) { this.dataContratacao = dataContratacao; }

    public List<Cargo> getCargo() { return cargos; }
    public void setCargo(List<Cargo> cargo) { this.cargos = cargo; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
}

