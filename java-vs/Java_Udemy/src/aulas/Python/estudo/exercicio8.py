valor_compra = float(input("Digite o valor da compra: R$ "))
valor_pago = float(input("Digite o valor pago: R$ "))

# Verificando a consistência do pagamento
if valor_pago < valor_compra:
    print("Erro: Valor pago é menor que o valor da compra.")
elif valor_pago == valor_compra:
    print("Pagamento exato.")
else:
    troco = valor_pago - valor_compra
    print(f"Troco a ser devolvido: R$ {troco:.2f}")