qtd_pares = 0
digitado = 0

while (digitado != -1):
    digitado = int(input("digite um numero: "))
    if (digitado % 2 == 0):
        qtd_pares = digitado + 1
print("quantidade pares é ", qtd_pares)
