package Empresa.FuncionariosFun.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Empresa.FuncionariosFun.model.Cargo;
import Empresa.FuncionariosFun.service.CargoService;

@RestController
@RequestMapping("/cargos")
public class CargoController {
    
    private final CargoService cargoService;

    public CargoController(CargoService cargoService){
        this.cargoService = cargoService;
    }

    //metodos Get
    @GetMapping()
    public List<Cargo> listarCargos(){
        return cargoService.listarCargos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> procurarCargoID(@PathVariable int id){
        return cargoService.procurarCargoID(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //metodo Post cadastro
    @PostMapping()
    public ResponseEntity<Cargo> cadastrarCargo(@RequestBody Cargo novoCargo){
        return ResponseEntity.status(HttpStatus.CREATED).body(cargoService.cadastrarCargo(novoCargo));
    }

    //metodo Put atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Cargo> atualizarCargo(@PathVariable int id, @RequestBody Cargo cargoAtt){
        return ResponseEntity.status(HttpStatus.OK).body(cargoService.atualizarCargo(id, cargoAtt));
    }
     
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCargo(@PathVariable int id){
        cargoService.deletarCargo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
