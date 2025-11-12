
notas = []
for i in range(5):
    print("Digite a nota", i + 1, ":")
    nota = float(input("digite a nota: "))
    notas.append(nota)

soma = 0
for nota in notas:
    soma += nota

media = soma / len(notas)

media_formatada = int(media * 100) / 100.0
print("Média:", media_formatada)

if media >= 7:
    print("Situação: Aprovado")
elif 5 <= media < 6.5:
    print("Situação: Recuperação")
else:
    print("Situação: Reprovado")