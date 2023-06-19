from queue import Queue
import time


portos = []
celebrian = Queue()

print("\nBeeenvenido al puejto de Veracru \n")
print("\nLos ferris disponibles son: \n")
print("\n1. El ferry Portos con direccio al puejto de Baja Califonia Su \n")
print("\n2. El ferry Celebrian con direccio al puejto de Salina Cru \n")

while True:
    print("\nIngrese la matricula del auto (o 'salir' para cancelar) \n")
    matricula = input()

    if matricula == "salir":
        break

    print("\nIngrese el ferris en el que desea que vaya el auto (P - Portos, C- Celebrian): \n")
    ferris = input()

    if ferris.upper() == "P":
        if len(portos) < 10:
            portos.append(matricula)
            print(f"\nEl auto con matricula {matricula} ha entrado al Ferry Portos \n")
            print("\nLos autos que estan en el Ferry Portos son: \n")
            print(portos)
            print("\nLos autos que estan en el Ferry Celebrian son: \n")
            print(list(celebrian.queue))
        else:
            print("\nCapacidad maxima de Portos alcanzada. No ha podido ingresar el auto. \n")
    elif ferris.upper() == "C":
        if celebrian.qsize() < 10:
            celebrian.put(matricula)
            print(f"\nEl auto con matricula {matricula} ha entrado al Ferry Celebrian \n")
            print("\nLos autos que estan en el Ferry Portos son: \n")
            print(portos)
            print("\nLos autos que estan en el Ferry Celebrian son: \n")
            print(list(celebrian.queue))
        else:
            print("\nCapacidad maxima de Celebrian alcanzada. No ha podido ingresar el auto \n")
    else:
        print("\nOpcion invalida. Ingrese P para mandar el auto a Portos o C para el Celebrian \n")


print("\nIniciando el viaje de ambos ferrys...\n")

# Codigo para la animacion del viaje de los ferrys
velas1= " "*5+u"\u2571"+u"\u23AA"+" "+u"\u23AA"+u"\u2572"
velas2= " "*4+u"\u2571"+" "+u"\u23AA"+" "+u"\u23AA"+" "+u"\u2572"
velas3= " "*3+u"\u2571"+"__"+u"\u23AA"+" "+u"\u23AA"+"__"+u"\u2572"
mastiles= " "*6+u"\u23AA"+" "+u"\u23AA"
timonel= " "*2+u"\u2599"+u"\u2588"*10+u"\u259f"
print ("\n"*5)
print ("\033[11;0H"+"\033[0;34;44m"+u"\u2588"*80+"\033[0m")
for i in range(20):
 v=i+1
 print ("\033[6;%dH"%v+velas1)
 print ("\033[7;%dH"%v+velas2)
 print ("\033[8;%dH"%v+velas3)
 print ("\033[9;%dH"%v+mastiles)
 print ("\033[10;%dH"%v+timonel)
 time.sleep(0.5)
while i>0:
 v=i+1
 print ("\033[6;%dH"%v+velas1+"\033[0K")
 print ("\033[7;%dH"%v+velas2+"\033[0K")
 print ("\033[8;%dH"%v+velas3+"\033[0K")
 print ("\033[9;%dH"%v+mastiles+"\033[0K")
 print ("\033[10;%dH"%v+timonel+"\033[0K")
 i=i-1
 time.sleep(0.5)
print("\n\nLos ferrys han llegado a su destino...\n\n")

while portos:
    print("\nEl auto con matricula {} ha salido del Ferry Portos \n".format(portos.pop()))
    print("\nLos autos que estan en el Ferry Portos son: \n")
    print(portos)
    print("\nLos autos que estan en el Ferry Celebrian son: \n")
    print(list(celebrian.queue))

while not celebrian.empty():
    print("\nEl auto con matricula {} ha salido del Ferry Celebrian \n".format(celebrian.get()))
    print("\nLos autos que estan en el Ferry Portos son: \n")
    print(portos)
    print("\nLos autos que estan en el Ferry Celebrian son: \n")
    print(list(celebrian.queue))

print("\nTodos los autos han salido \n")
print("\nFin del viaje de ambos ferrys...\n")
