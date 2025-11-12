sexo = input("Qual seu sexo: ")
altura = float(input("qual sua Altura: "))
pesso = float(input("qual seu peso: "))
imc =   pesso / (altura * altura )  

if (sexo == "Mulher"):
    if (imc < 19.1):
        print("Abaixo do pesso ideal")
    elif (imc >= 19.1 and imc < 25.8):
        print("No pesso ideal")
    elif(imc >= 25.8 and imc < 27.3):
        print("arginalmente acima do pesso")
    elif(imc >= 27.3 and imc < 32.3):
        print("acima do pesso ideal")
    else:
        print("obeso")

if (sexo == "Homem"):
    if (imc <20.7):
        print("Abraixo do pesso ideal")
    elif (imc >= 20.7 and imc < 26.4):
        print("No pesso ideal")
    elif(imc >= 26.4 and imc < 27.8):
        print("arginalmente acima do pesso")
    elif(imc >= 27.8 and imc < 31.1):
        print("acima do pesso ideal")
    else:
        print("obeso")



 
  
