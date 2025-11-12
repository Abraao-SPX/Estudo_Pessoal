valor_compra = float(input("Digite o valor da compra: R$ "))
zona_entrega = input("Digite a zona de entrega (urbana/suburbana/rural): ")

# Verificando a zona de entrega e calculando o frete
if valor_compra > 300 and zona_entrega == "urbana":
    frete = 0
    print(f"Frete grátis!")
else:
    if zona_entrega == "urbana":
        frete = 10
    elif zona_entrega == "suburbana":
        frete = 20
    elif zona_entrega == "rural":
        frete = 35
    else:
        print("Zona de entrega inválida!")
        frete = 0  # Definindo o frete como 0 em caso de zona inválida

# Calculando o total da compra
total_compra = valor_compra + frete

# Saída
print(f"Valor do frete: R$ {frete:.2f}")
print(f"Total da compra (com frete): R$ {total_compra:.2f}")