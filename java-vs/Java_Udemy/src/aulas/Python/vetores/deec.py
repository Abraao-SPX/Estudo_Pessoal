lista = ["1-coxinha   (uni - R$5.00)","2-pastel  ( uni - R$6.00)","3-suco( uni - R$4.00)  "]
estoque = [10,8,15]
tn = ("S")

menu = 0
while menu != 4:
    print  ("1- realizar pedido \n2- consultar estoque\n3- apastecer estoque\n4- sair")
    menu = int(input("o que você deseja fazer?:"))

    if menu == 1:
        print (lista)
        pedido = int(input("qual seu pedido?: "))
        quantidade = int(input("quantos você quer?: "))
        if quantidade <= estoque[pedido - 1]:
            print (f"você comprou {quantidade} {lista[pedido - 1]}")
            estoque[pedido - 1] = estoque[pedido - 1] - quantidade
        else:
            print ("não temos essa quantidade!")
    if menu == 2:
        print (f"temos {estoque[0]} coxinha(s), {estoque[1]} pastel(s), e {estoque[2]} suco(s) ")

    while tn != "n" or tn != "N":
        if menu == 3:
            senha = input("qual a senha:")
            if senha == "adimin123":
                print (f"1- {lista[0]} {estoque[0]} , 2- {lista[1]} {estoque[1]} e 3- {lista[2]} {estoque[2]}")
                pedido = int(input("qual produto você deseja aumentar?: "))
                aumento = int(input("quantos produtos você deseja adicionar?: "))
                estoque = (aumento + estoque[pedido - 1])
                print (estoque)
            else:
                print("senha incorreta!!")
                tn = input("deseja tentar novamente?:(s/n)")
print ("você saiu!")