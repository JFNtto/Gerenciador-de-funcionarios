package Empresa.FuncionariosFun.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import Empresa.FuncionariosFun.dto.FuncionarioDTO;
import Empresa.FuncionariosFun.model.Cargo;
import Empresa.FuncionariosFun.model.Funcionario;
import Empresa.FuncionariosFun.repository.CargoRepository;
import Empresa.FuncionariosFun.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private final CargoRepository cargoRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, CargoRepository cargoRepository){
        this.funcionarioRepository = funcionarioRepository;
        this.cargoRepository = cargoRepository;
    }

    //cadastro de funcionario
    public Funcionario cadastrarFuncionario(FuncionarioDTO funcionarioDTO){
        List<Cargo> cargos = cargoRepository.findAllById(funcionarioDTO.getCargosIds());

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setDataContratacao(funcionarioDTO.getDataContratacao());
        funcionario.setSalario(funcionarioDTO.getSalario());
        funcionario.setCargo(cargos);

       return funcionarioRepository.save(funcionario);
    }

    //listagem e procura
    public List<Funcionario> listarFuncionarios(){
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> procurarFuncionarioID(int idBusca){
        return funcionarioRepository.findById(idBusca);
    }


    //atualização
    public Funcionario atualizarFuncionario(int idBusca, FuncionarioDTO funcionarioDTO){
        Funcionario func = procurarFuncionarioID(idBusca).orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));

        func.setNome(funcionarioDTO.getNome());
        List<Cargo> cargos = cargoRepository.findAllById(funcionarioDTO.getCargosIds());
        func.setCargo(cargos);
        func.setSalario(funcionarioDTO.getSalario());
        func.setDataContratacao(funcionarioDTO.getDataContratacao());

        return funcionarioRepository.save(func);
    }


    //deletar
    public void deletarFuncionario(int idDelete){
        funcionarioRepository.deleteById(idDelete);
    }
}
