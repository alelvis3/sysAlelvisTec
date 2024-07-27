# sysAlelvisTec
Em desenvolvimento!!!!

Este é um projeto de assistência técnica desenvolvido com Java e Spring Boot. A aplicação fornece uma interface RESTful para gerenciar e consultar informações relacionadas à assistência técnica.

## Funcionalidades

- Interface RESTful para operações de assistência técnica.
- Documentação da API gerada pelo SpringDoc.
- Conexão com banco de dados MySQL.

## Configuração das Variáveis de Ambiente

### Passo 1: Configuração das Variáveis de Ambiente

#### Windows

1. **Abrir as Configurações do Sistema**:
   - Pressione `Win + R`, digite `sysdm.cpl` e pressione `Enter`.
   - Vá para a aba **Avançado** e clique em **Variáveis de Ambiente**.

2. **Adicionar Variáveis**:
   - Em **Variáveis do Sistema**, clique em **Nova** para adicionar novas variáveis.
   - Adicione as variáveis:
     - `DB_HOST_MYSQL` com o valor `seu_endereco_mysql`.
     - `DB_USER_MYSQL` com o valor `seu_usuario_mysql`.
     - `DB_PASSWORD_MYSQL` com o valor `sua_senha_mysql`.

3. **Confirmar e Aplicar**:
   - Clique em **OK** para fechar as janelas e aplicar as alterações.

#### Linux / macOS

1. **Editar o Arquivo de Configuração do Shell**:
   - Para **bash**, edite o arquivo `~/.bashrc` (Linux) ou `~/.bash_profile` (macOS).
   - Para **zsh**, edite o arquivo `~/.zshrc`.

2. **Adicionar Variáveis**:
   - Abra o arquivo com um editor de texto, como `nano` ou `vim`:
     ```bash
     nano ~/.bashrc   # Para Linux
     nano ~/.bash_profile  # Para macOS
     ```
   - Adicione as seguintes linhas ao final do arquivo:
     ```bash
     export DB_HOST_MYSQL=seu_endereco_mysql
     export DB_USER_MYSQL=seu_usuario_mysql
     export DB_PASSWORD_MYSQL=sua_senha_mysql
     ```

3. **Aplicar as Alterações**:
   - Salve o arquivo e aplique as alterações com o comando:
     ```bash
     source ~/.bashrc   # Para Linux
     source ~/.bash_profile  # Para macOS
     ```
     
     
     
## Autor

**Nome:** Alexandre de Souza Marques  
**Email:** [alelvis3br@hotmail.com](mailto:alelvis3br@hotmail.com)  
**GitHub:** [https://github.com/alelvis3/sysAlelvisTec.git](https://github.com/alelvis3/sysAlelvisTec.git)