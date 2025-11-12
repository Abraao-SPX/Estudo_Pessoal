# Taxas fixas
taxa_dolar = 5.20
taxa_euro = 5.60

# Entrada de dados
valor_reais = float(input("Digite o valor em reais: "))
moeda_destino = input("Digite a moeda de destino (dólar ou euro): ").lower()

# Conversão e verificação
if moeda_destino == "dólar":
    valor_convertido = valor_reais / taxa_dolar
    if valor_convertido > 200:
        print(f"Alerta: A transação ultrapassa 200 dólares. Transação internacional.")
    print(f"O valor convertido para dólares é: ${valor_convertido:.2f}")
elif moeda_destino == "euro":
    valor_convertido = valor_reais / taxa_euro
    if valor_convertido > 200:
        print(f"Alerta: A transação ultrapassa 200 euros. Transação internacional.")
    print(f"O valor convertido para euros é: €{valor_convertido:.2f}")
else:
    print("Moeda de destino inválida! Por favor, escolha 'dólar' ou 'euro'.")
