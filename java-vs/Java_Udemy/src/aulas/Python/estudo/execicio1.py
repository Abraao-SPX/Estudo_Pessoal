nome = input("Qual seu nome: ")
perfil = input("Perfil de acesso: ")
dia = input("Dia da semana: ")
hora = int(input("Hora atual: "))

if perfil == "administrador":
    print(f"{nome}, Acesso a qualquer hora")

elif perfil == "financeiro":  
    if 8 <= hora < 18:
        print(f"{nome}, Acesso permitido")
    else:
        print("Acesso negado")

elif perfil == "tecnico":
    if dia == "domingo":  
        print("Acesso negado")
    elif 6 <= hora < 22:  
        print("Acesso permitido das 6h às 22h")
    else:
        print("Acesso negado")

else:
    print(f"{nome}, perfil inválido")  










