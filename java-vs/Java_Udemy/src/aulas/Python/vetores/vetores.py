# indice pocição de cada um
# na fila o primeiro que chega é o primeiro a sair
# pilha quem sai primeiro é quem entra por último
# aprender lisat
#  aprender for e while em python / um pouco diferenete de java
# estudar menu py


salarios = []

n = int(input("Quantos salários deseja informar? "))
for i in range(n):
    salario = float(input(f"Digite o salário do trabalhador {i + 1}: "))
    salarios.append(salario)

soma = 0
for salario in salarios:
    soma += salario

media = soma / n  

maior_salario = salarios[0]
for salario in salarios:
    if salario > maior_salario:
        maior_salario = salario

salarios_menores_850 = 0
for salario in salarios:
    if salario < 850.00:
        salarios_menores_850 += 1

print(f"\nMédia dos salários: R${media:.2f}")
print(f"Maior salário: R${maior_salario:.2f}")
print(f"Quantidade de salários menores que R$850,00: {salarios_menores_850}")
