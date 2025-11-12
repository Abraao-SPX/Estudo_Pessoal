idade = int(input("Qual a sua idade? "))
estudante = input("É estudante (sim ou não)? ")
carteira = input("Possui carteirinha válida (sim ou não)? ")
tipo = input("Qual o tipo de ingresso (meia ou inteira)? ")
valor = float(input("Qual o valor do ingresso? "))

if idade >= 60:
    print(f"O valor pago é de {valor - (valor * 70 / 100)}")
elif idade < 12:
    print(f"O valor pago é de {valor - (valor * 60 / 100)}")
elif estudante == "sim" and carteira == "sim":
    print(f"O valor pago é de {valor - (valor * 50 / 100)}")
elif idade > 12 and idade <= 17:
    print(f"O valor pago é de {valor - (valor * 30 / 100)}")
else:
    print(f"O valor pago é de {valor}")
