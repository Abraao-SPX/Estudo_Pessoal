#forma do profesor

notas = []
for i in range(5):
    print("Digite a nota", i + 1, ":")
    nota = float(input())
    notas.append(nota)

media = 0 
for i in range(5):
    media += notas[i]