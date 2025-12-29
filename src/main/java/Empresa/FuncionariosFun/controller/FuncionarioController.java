package Empresa.FuncionariosFun.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Empresa.FuncionariosFun.dto.FuncionarioDTO;
import Empresa.FuncionariosFun.model.Funcionario;
import Empresa.FuncionariosFun.service.FuncionarioService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;
    public FuncionarioController(FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public List<Funcionario> listarFuncionarios(){
        return funcionarioService.listarFuncionarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> procurarFuncionarioID(@PathVariable int id) {
        return funcionarioService.procurarFuncionarioID(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Funcionario> cadastrarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.cadastrarFuncionario(funcionarioDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable int id, @RequestBody FuncionarioDTO funcionarioDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.atualizarFuncionario(id, funcionarioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable int idDeletar){
        funcionarioService.deletarFuncionario(idDeletar);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    

}
