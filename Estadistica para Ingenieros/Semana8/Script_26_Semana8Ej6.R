# Crear matriz de datos
tabla_datos = matrix(
  c(352, 197, 251,150, 161, 194),
  nrow = 2,
  byrow = TRUE,
  dimnames = list(
    Modalidad = c("Tiempo completo", "Tiempo parcial"),
    Pregrado = c("Negocios", "Ingeniería", "Economía")
  )
)
tabla_datos
#matrix() crea una matriz en R, que es una estructura de datos bidimensional (filas y columnas).
#c() crea un vector de valores numéricos que serán los contenidos de la matriz.
#nrow indica que la matriz tendrá 2 filas.
#byrow = TRUE significa que se llenará por filas dimnames da nombres a las filas y columnas de la matriz.

# Total general
total = sum(tabla_datos)

#Agregar los totales a la matriz
tabla = addmargins(tabla_datos)
tabla

#Crear la tabla de probabilidades 
tabla_prob=round(tabla/total,3)
tabla_prob

#sum( ) Suma todos los elementos de la matriz.
#addmargins(tabla) Añade márgenes o totales a la matriz.

