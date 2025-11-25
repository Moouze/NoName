package com.maninho.Sistema.maninho.controller;

import com.maninho.Sistema.maninho.dto.UserRequestDTO;
import com.maninho.Sistema.maninho.dto.UserResponseDTO;
import com.maninho.Sistema.maninho.services.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> addUsersChild(@RequestBody @Valid UserRequestDTO dto){
        UserResponseDTO resposta = usersService.CadastrarUsers(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll(){
        List<UserResponseDTO> users = usersService.findAll();

        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDTO> deleteById(@PathVariable Long id){
         usersService.excluirUser(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> userUpdate(@PathVariable Long id,@RequestBody @Valid UserRequestDTO dto ){
        UserResponseDTO userResponseDTO = usersService.atualizarUsuario(id, dto);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById (@PathVariable Long id){
        UserResponseDTO userResponseDTO = usersService.findById(id);

        return ResponseEntity.ok(userResponseDTO);
    }
}
