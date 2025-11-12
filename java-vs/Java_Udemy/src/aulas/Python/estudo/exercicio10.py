# Usuários cadastrados
usuario1 = {"nome": "admin", "senha": "123", "acesso": "total"}
usuario2 = {"nome": "jose", "senha": "abc", "acesso": "parcial"}
usuario3 = {"nome": "maria", "senha": "456", "acesso": "restrito"}

# Entradas
usuario_informado = input("Digite o nome de usuário: ")
senha_informada = input("Digite a senha: ")

# Verificando as credenciais
if usuario_informado == usuario1["nome"]:
    if senha_informada == usuario1["senha"]:
        print(f"Bem-vindo, {usuario1['nome']}! Seu acesso é: {usuario1['acesso']}")
        print("Você tem acesso total.")
    else:
        print("Senha incorreta. Tente novamente.")
elif usuario_informado == usuario2["nome"]:
    if senha_informada == usuario2["senha"]:
        print(f"Bem-vindo, {usuario2['nome']}! Seu acesso é: {usuario2['acesso']}")
        print("Você tem acesso parcial. Algumas áreas podem ser restritas.")
    else:
        print("Senha incorreta. Tente novamente.")
elif usuario_informado == usuario3["nome"]:
    if senha_informada == usuario3["senha"]:
        print(f"Bem-vindo, {usuario3['nome']}! Seu acesso é: {usuario3['acesso']}")
        print("Você tem acesso restrito. Não pode acessar áreas críticas.")
    else:
        print("Senha incorreta. Tente novamente.")
else:
    print("Usuário não encontrado. Tente novamente.")
