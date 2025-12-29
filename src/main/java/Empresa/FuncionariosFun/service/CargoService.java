package Empresa.FuncionariosFun.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import java.util.List;

import Empresa.FuncionariosFun.model.Cargo;
import Empresa.FuncionariosFun.repository.CargoRepository;


@Service
public class CargoService {
    private final CargoRepository cargoRepository;

    public CargoService(CargoRepository cargoRepository){
        this.cargoRepository = cargoRepository;
    }


    //cadastro
    public Cargo cadastrarCargo(Cargo novoCargo){
        return cargoRepository.save(novoCargo);
    }


    //listagem e procura
    public List<Cargo> listarCargos(){
        return cargoRepository.findAll();
    }

    public Optional<Cargo> procurarCargoID(int idBusca){
        return cargoRepository.findById(idBusca);
    }

    //atualizar o cargo
    public Cargo atualizarCargo(int id, Cargo cargoAtt){
        Cargo nCargo = procurarCargoID(id).orElseThrow(() -> new RuntimeException("Cargo não encotrado"));

        nCargo.setNome(cargoAtt.getNome());
        
        return cargoRepository.save(nCargo);
    }

    //deletar
    public void deletarCargo(int idDelete){
        cargoRepository.deleteById(idDelete);
    }
}
