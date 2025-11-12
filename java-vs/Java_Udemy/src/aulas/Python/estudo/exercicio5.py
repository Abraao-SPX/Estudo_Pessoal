tipo_conversao = input("Digite o tipo de conversão (C→F, F→C, C→K): ")
temperatura = float(input("Digite a temperatura: "))
localizacao = input("Digite sua localização: ")

# Conversão e alerta
if tipo_conversao == "C→F":
    temperatura_convertida = (temperatura * 9/5) + 32
    if temperatura_convertida < 32 or temperatura_convertida > 104:
        print(f"⚠️ Alerta extremo para {localizacao}")
    print(f"Temperatura convertida: {temperatura_convertida:.2f}°F")
    
elif tipo_conversao == "F→C":
    temperatura_convertida = (temperatura - 32) * 5/9
    if temperatura_convertida < 0 or temperatura_convertida > 40:
        print(f"⚠️ Alerta extremo para {localizacao}")
    print(f"Temperatura convertida: {temperatura_convertida:.2f}°C")
    
elif tipo_conversao == "C→K":
    temperatura_convertida = temperatura + 273.15
    if temperatura_convertida < 273.15 or temperatura_convertida > 313.15:
        print(f"⚠️ Alerta extremo para {localizacao}")
    print(f"Temperatura convertida: {temperatura_convertida:.2f}K")

else:
    print("Tipo de conversão inválido. Por favor, escolha entre C→F, F→C ou C→K.")