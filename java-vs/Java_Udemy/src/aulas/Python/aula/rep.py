somaPares = 0

for i in range(10):
    valor = int(input(f"Digite o {i+1}º número: "))
    if valor % 2 == 0:
        somaPares += valor

print("A soma dos números pares é:", somaPares)