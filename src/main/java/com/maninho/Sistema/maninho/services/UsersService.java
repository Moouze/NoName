package com.maninho.Sistema.maninho.services;

import com.maninho.Sistema.maninho.dto.UserRequestDTO;
import com.maninho.Sistema.maninho.dto.UserResponseDTO;
import com.maninho.Sistema.maninho.model.Users;
import com.maninho.Sistema.maninho.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private EmailService emailService;

    public UserResponseDTO CadastrarUsers(UserRequestDTO dto) {
        if (usersRepository.existsByLogin(dto.getLogin())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Esse e-mail já foi cadastrado");
        }
        Users usersChild = dto.converterParaEntidade();
        usersChild = usersRepository.save(usersChild);

        emailService.enviarEmail(
                usersChild.getLogin(),
                "Bem-vindo ao sistema! \n",
                "Olá Jovem, seu cadastro foi realizado com sucesso!" +
                        "Segue seus dados para acessar o sistema: \n\n"
                        + "Login: " + usersChild.getLogin() + "\n"
                        + "Senha: " + usersChild.getPassword()
        );

        return UserResponseDTO.ConverterParaDto(usersChild);
    }

    public List<UserResponseDTO> findAll() {
        List<Users> users = usersRepository.findAll();

        return users.stream().map(UserResponseDTO::ConverterParaDto)
                .collect(Collectors.toList());
    }

    public void excluirUser(Long id) {
        Users users = usersRepository.findById(id).orElseThrow
                (() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não existe!!!"));
        usersRepository.delete(users);
    }

    public UserResponseDTO atualizarUsuario(Long id, UserRequestDTO dto) {
        Users users = usersRepository.findById(id).orElseThrow
                (() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não existe!!!"));
        users.setLogin(dto.getLogin());
        users.setPassword(dto.getPassword());

        if (usersRepository.existsByLogin(dto.getLogin())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "E-mail já está cadastrado!!!");
        }

        Users userAtt = usersRepository.save(users);

        return UserResponseDTO.ConverterParaDto(userAtt);
    }

    public UserResponseDTO findById(Long id) {
        Users users = usersRepository.findById(id).orElseThrow
                (() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não existe!!!"));

        return UserResponseDTO.ConverterParaDto(users);
    }
}
