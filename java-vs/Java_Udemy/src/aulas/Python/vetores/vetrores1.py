# jeito do professor

continuar = "s"
salario = []
maior = 0
menor = 0



while (continuar == "s"):
    s = float(input("Digite o salário do trabalhador: "))
    salario.append(s)
    continuar = input("Deseja continuar? (s/n): ")

soma = 0
for i in range(len(salario)):
    soma += salario[i]


if maior < salario[i]:
    maior = salario[i]


if salario[i] < 850:
    menor += 1

print(f"A média dos salários é: {soma / len(salario)}")
print("O maior salário é:", maior)
print("Quantidade < 850:", menor)