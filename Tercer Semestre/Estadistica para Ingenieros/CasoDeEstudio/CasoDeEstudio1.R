# encontrar los tipos de variables y la cantidad total de datos vacios en la base de datos
str(ventas_tienda_202510)
faltantes=sum(is.na(ventas_tienda_202510)) # = 500


# ClienteID
# int 
summary(ventas_tienda_202510$ClienteID)
sum(is.na(ventas_tienda_202510$ClienteID)) # = 0

# Edad
# int
summary(ventas_tienda_202510$Edad)
sum(is.na(ventas_tienda_202510$Edad)) # = 200

# FechaCompra
summary(ventas_tienda_202510$FechaCompra)
sum(is.na(ventas_tienda_202510$FechaCompra)) # = 0

# Genero
# chr
summary(ventas_tienda_202510$Genero)
sum(is.na(ventas_tienda_202510$Genero)) # = 0

# CategoriaProducto
# chr
summary(ventas_tienda_202510$CategoríaProducto)
sum(is.na(ventas_tienda_202510$CategoríaProducto)) # = 0

# FechaCompra
summary(ventas_tienda_202510$FechaCompra)
sum(is.na(ventas_tienda_202510$FechaCompra)) # = 0

# Precio
# num
summary(ventas_tienda_202510$Precio)
sum(is.na(ventas_tienda_202510$Precio)) # = 100

# Cantidad
# int
summary(ventas_tienda_202510$Cantidad)
sum(is.na(ventas_tienda_202510$Cantidad)) # = 0

# Descuento
# num
summary(ventas_tienda_202510$Descuento)
sum(is.na(ventas_tienda_202510$Descuento)) # = 150

# MetodoPago
# chr
summary(ventas_tienda_202510$MétodoPago)
sum(is.na(ventas_tienda_202510$MétodoPago)) # = 50