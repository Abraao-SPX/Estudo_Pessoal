nome = input("Qual o nome do aluno? ")
nota1 = float(input("Digite a nota 1: "))
nota2 = float(input("Digite a nota 2: "))
faltas = int(input("Quantas aulas o aluno faltou? "))


media = (nota1 + nota2) / 2


carga_horaria = 60
faltas_maximas = carga_horaria * 0.25 


if faltas > faltas_maximas:
    print(f"{nome}, você foi reprovado por falta.")
else:
    if media < 5:
        print(f"{nome}, sua média é {media:.1f}. Você foi reprovado por nota.")
    elif 5 <= media < 7:
        print(f"{nome}, sua média é {media:.1f}. Você está em recuperação.")
    else:
        print(f"{nome}, sua média é {media:.1f}. Você foi aprovado.")