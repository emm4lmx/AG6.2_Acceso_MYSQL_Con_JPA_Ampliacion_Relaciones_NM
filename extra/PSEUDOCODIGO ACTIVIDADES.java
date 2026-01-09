inicio
    escribe
    leer

    si condicion
    sino
    finsi

    durante xveces
    findurante

    mientras condicion
    finmientras

    hacer
    mientas condicion

    switch
        case 1
        case 2
        case 3
    break
fin

//ejercio 1
inicio
    escribe "introduce un numero"
    lee num1
    escribe "introduce otro numero"
    lee num2
    suma = num1 + num2
    escribe num1 + "+" + num2 + "=" suma
fin

//ejercicio 2
inicio
    escribe "introduce un numero"
    lee num
    si num no es numero
        escribe "error, valor no valido" //sale del programa
    sino
        resto = num%2 //calcular resto
        si resto==0 //comparar resto con 0 para saber si es par o impar
            escribe "el numero " + num + " es par"
        sino
            escribe "el numero " + num + " es impar"
        finsi
    finsi
fin


//ejercicio 2 (v.2)
inicio
    escribe "introduce un numero"
    lee num
    mientras num no es numero //comprueba que el valor sea un numero
        escribe "valor no valido, introduce otro numero"
        lee num
    finmientras
    resto = num%2 //calcula el resto de la division
    si resto==0 //compara el resultado con 0 para saber si es par o impar
        escribe "el numero " + num + " es par"
    sino
        escribe "el numero " + num + " es impar"
    finsi
fin




//ejercicio 3
inicio
    escribe "introduce un numero" //pide un numero
    lee num1
    mientras num1 no es numero //comprueba que el valor sea un numero
        escribe "valor no valido, introduce otro numero"
        lee num1
    finmientras
    escribe "introduce otro numero"
    lee num2
    mientras num2 no es numero
        escribe "valor no valido, introduce otro numero"
        lee num2
    si num1 > num2 //compruebo si el numero 1 es mayor que el numero 2 y evlauo el resultado segun las dos opciones
        escribe "el " + num1 " es mayor que " + num2
    sino si num2>num1
        escribe "el " + num2 " es mayor que " + num1
        sino
        escribe "los numeros son iguales"
        finsi
    finsi
fin


//ejercicio 4
inicio
    escribe "introduce un numero"
    lee num1
    mientras num no es numero
        escribe "valor no valido, introduce otro numero"
        lee num1
    finmientras
    escribe "introduce otro numero"
    lee num2
    mientras num2 no es numero
        escribe "valor no valido, introduce otro numero"
        lee num2
    finmientras
    escribe "introduce una operacion (+; -; *; /)"
    lee operacion
    mientas operacion no es (+; -; *; /)
        escribe "operacion no valida, introduce otra"
        lee operacion
    fin mientras
    op = 0
    si operacion == "+" //hacer la operacion correspondiente
        op = num1 + num2
    sino si operacion == "-"
            op = num1 - num2
        sino si operacion == "*"
                op = num1 * num2
            sino
                op = num1 / num2
            finsi
        finsi
    finsi
    escribe num1 " " + op + " " num2 " = " + op //escribir resultado
fin


//ejercicio 5 (3 intentos)
inicio
    user=""
    pass=""
    intentos=0
    durante (intentos<3) //le doy al usuario 3 intentos para acertar el usuario y la contraseña
        escribe "introduce tu usuario"
        lee user
        escribe "introduce tu contraseña"
            lee pass
        si user=="admin" and pass=="1234" //si ambas son correctas pasa como verdadero
            escribe "acceso concedido"
            intentos=4 //cambio el valor de la variable para salir del bucle
        sino
            escribe "acceso denegado"
            intentos=intentos+1 //tambien se puede poner intentos ++; intentos +=1
        finsi
    findurante
fin

//ejercicio 5 (v.2); infinitos intentos

inicio
//en este caso no es necesario crear las variables porque no entran en la condicion
    salir=false
    mientras (!salir) //le da la vuelta al falso (lo cambia a verdadero; tiene que ser verdadero para entrar en el bucle) -- tambien se puede poner salir==true
        escribe "introduce tu usuario"
        lee user
        escribe "introduce tu contraseña"
            lee pass
        si user=="admin" and pass=="1234" //si ambas son correctas pasa como verdadero
            escribe "acceso concedido"
            salir=true //cambio el valor de la variable para salir del bucle
        sino
            escribe "acceso denegado, ¿quieres volver a intentarlo? (S/N)"
            lee respuesta
            si respuesta != "S" //simbolo distinto de (!=)
                salir=false
            finsi
        finsi
    finmientras
fin



//ejercicio 6
inicio
    edad=0
    rangoe=""
    escribe "introduce tu edad"
    lee edad
    mientras edad no es numero
        escribe "parametro no valido, introduce otro"
        lee edad
    finmientras
    si edad<=17
        rangoe="menor de edad"
    sino si edad<=30
        rangoe="adulto joven"
    sino si edad<=64
        rangoe="adulto"
    sino
        rangoe="adulto mayor"
    finsi
    escribe "con " + edad + " años se te considera " + rangoe
fin

//ejercicio 7
inicio
    contador=1 //inicio las variables
    salida=""
    escribe "introduce un numero positivo"
    lee num
    mientras num<0 //si el usuario mete un numero negativo o un cero entra en el bucle
        escribe "introduce un numero positivo"
        lee num
    finmientras
    durante contador<num
        salida = salida + contador + ", "
        contador ++
    findurante    
    escribe salida + num
fin


//ejercicio 8
inicio
    suma=0
    resulactual=0
    escribe "introduce un numero"
    lee num
    mientras num>=0
        resulactual=suma+num //suma += num (es lo mismo)
        escribe "introduce otro numero"    
        lee num
    finmientras
    escribe "la suma total es de " + suma
fin

//ejercicio 9
inicio
    tempfinal=0 //iniciar variables
    udanterior=""
    escribe "a que unidad quieres convertir tu temperatura (F/C)"
    lee udconv
    finsi
    si udconv == "C"
        udanterior="F"
        escribe "cual es ta temperatura que quieres pasar a celsius"
        lee temp
        temmpfinal = (temp-32)*5/9
    sino
        udanterior="C"
        escribe "cual es la temperatura que quieres pasar a farenheit"
        lee temp
        tempfinal = (temp * 9/5) + 32
    finsi
    escribe temp + "º " + udanterior + " son " + tempfinal + "º " + udconv
fin


//ejercicio 10
inicio
    total=0
    decision="S"
    cambio=0
    escribe "cual es el precio del atriculo"
    lee precio
    mientras precio<0
        escribe "precio no valido, introduce otro"
        lee precio
    finmientras
    mientras decision=="S"
        total = total + precio
        escribe "quieres seguir escaneando articulos? (S/N)"
        lee decision
        escribe "introduce otro precio"
        lee precio
        mientras precio<0
            escribe "precio no valido, introduce otro"
            lee precio
        finmientras
    finmientras
    escribe "cuanto dinero entregas?"
    lee dinero
    cambio = dinero-total
    escribe "el total a pagar son " + total + "€ " + ", el cliente entrega " + dinero + " por lo que el cambio es de " + cambio
fin

