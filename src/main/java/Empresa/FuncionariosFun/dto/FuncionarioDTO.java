package Empresa.FuncionariosFun.dto;

import java.time.LocalDate;
import java.util.List;

public class FuncionarioDTO {
    private String nome;
    private LocalDate dataContratacao;
    private double salario;
    private List<Integer> cargosIds;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getDataContratacao() { return dataContratacao; }
    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    public List<Integer> getCargosIds() { return cargosIds; }
    public void setCargosIds(List<Integer> cargosIds) {
        this.cargosIds = cargosIds;
    }
}
