# Entradas
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

    # Cédulas e moedas disponíveis
    cédulas = [100, 50, 20, 10, 5, 2]
    moedas = [1, 0.5, 0.25, 0.1, 0.05]
    
    # Tratamento das cédulas
    c100 = int(troco // 100)
    troco -= c100 * 100
    if c100 > 0:
        print(f"{c100} cédula(s) de R$100.00")
    
    c50 = int(troco // 50)
    troco -= c50 * 50
    if c50 > 0:
        print(f"{c50} cédula(s) de R$50.00")
    
    c20 = int(troco // 20)
    troco -= c20 * 20
    if c20 > 0:
        print(f"{c20} cédula(s) de R$20.00")
    
    c10 = int(troco // 10)
    troco -= c10 * 10
    if c10 > 0:
        print(f"{c10} cédula(s) de R$10.00")
    
    c5 = int(troco // 5)
    troco -= c5 * 5
    if c5 > 0:
        print(f"{c5} cédula(s) de R$5.00")
    
    c2 = int(troco // 2)
    troco -= c2 * 2
    if c2 > 0:
        print(f"{c2} cédula(s) de R$2.00")

    # Tratamento das moedas
    m1 = int(troco // 1)
    troco -= m1 * 1
    if m1 > 0:
        print(f"{m1} moeda(s) de R$1.00")
    
    m50 = int(troco // 0.5)
    troco -= m50 * 0.5
    if m50 > 0:
        print(f"{m50} moeda(s) de R$0.50")
    
    m25 = int(troco // 0.25)
    troco -= m25 * 0.25
    if m25 > 0:
        print(f"{m25} moeda(s) de R$0.25")
    
    m10 = int(troco // 0.1)
    troco -= m10 * 0.1
    if m10 > 0:
        print(f"{m10} moeda(s) de R$0.10")
    
    m5 = int(troco // 0.05)
    troco -= m5 * 0.05
    if m5 > 0:
        print(f"{m5} moeda(s) de R$0.05")
