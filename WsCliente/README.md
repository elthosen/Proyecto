########		#           #      #######
#		#		# #        # #     #
#		#		#  #      #  #     #
#	   #		#   #    #   #     #
#	  #			#    #  #    #     #
#	   #		#     #      #     #
#		#		#			 #     #
#	     #		#			 #	   #
#	  	#   ##	# 			 # ##  #	
########	##	#			 # ##  ########

Prueba
Instrucciones para el servicio de factura

1. Para crear una factura se necesita que en la Db tenga valores en la tabla cliente, producto y tercero. Si no los tiene ejecutar los insert que se encuentran en el archivo "insert.sql".

2. Antes de guardar una factura se necesita que agregue los detalle de la factura. Eso se hace en la ruta del servicio: "http://localhost:8080/detaFacturas/parametro", por medio del metodo POST. Los datos a guardar se hacer en el body de un JSON Application, estos se encuentran en el archivo "Data fac-detfac.js"

3. Para elimar un detalle de la factura se aplica el siguiente servicio por medio del metodo DELETE: "http://localhost:8080/detaFacturas/parametro/{id}"

4. Para consultar un detalle de una factura se hace con el servicio por medio del metodo GET: "http://localhost:8080/detaFacturas/parametro/{id}"

5. Luego de agregar los detalles a la factura se procede a guardar la factura. Eso se hace por medio de la ruta del servicio: "http://localhost:8080/facturas", por medio del metodo POST. Los datos a guardar se hacer en el body de un JSON Application, estos se encuentran en el archivo "Data fac-detfac.js"

6. Para consultar todas las factura se hacer por el metodo GET: "http://localhost:8080/facturas" y para consultar solo 1: "http://localhost:8080/facturas/{id}"