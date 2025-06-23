# Datos
x_bar = 18.6      #Media muestral
s <-2.1           #Desviación estándar muestral
n<-25             #Tamano de la muestra
df<- n-1          #Grados de libertad
t <- qt(0.995, df) # 99% confianza

#Error estándar
ee <- s /sqrt(n)

# Intervalo
li <- x_bar - t * ee
ls <- x_bar - t * ee

cat("IC 99% con sigma desconocida:", round(li, 2), "a", round(ls, 2), "\n")


#Ejercicio 1
#En una muestra alegrarla simple con n = 54, la media muestra los 22.5 y la desviacion estándar muestral es 4.4
# a) Proporcione un intervalo de confianza de 90% para la medio poblacional.
# b) Determine un intervalo de confianza 95% para la media poblacional.
# c) Proporciona un Intervalo de confianza de 99% para la media poblacional.
# d) QUE sucede con al margen de error y el Intervalo de confianza a medida que aumenta el nivel de confianza?