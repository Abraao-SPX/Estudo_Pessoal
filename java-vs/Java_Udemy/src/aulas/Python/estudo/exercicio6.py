
nome_produto = input("Digite o nome do produto: ")
quantidade_estoque = int(input("Digite a quantidade em estoque: "))
perecivel = input("O produto é perecível? (sim/não): ")
preco_produto = float(input("Digite o preço do produto: "))

# Verificando a condição do estoque e aplicando a promoção
if perecivel == "sim" and quantidade_estoque > 100:
    print(f"Produto: {nome_produto} - Excesso de perecíveis — risco de perda")
elif quantidade_estoque < 10:
    print(f"Produto: {nome_produto} - Reposição urgente")
elif 10 <= quantidade_estoque <= 50:
    print(f"Produto: {nome_produto} - Reposição recomendada")
    # Aplicando a promoção (10% de desconto)
    preco_promocional = preco_produto * 0.9
    print(f"Aproveite nossa promoção! Preço com desconto: R${preco_promocional:.2f}")
else:
    print(f"Produto: {nome_produto} - Estoque alto")