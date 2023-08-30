Para correr la aplicación se deben borrar los archivos contenidos en la carpeta data del repositorio, los cuales son de las bases de datos generadas por la api. Al inciarse la aplicación se crean cuatros tablas, insertandose valores en las tablas CLIENTE y PRODUCTO. El archivo jar se encuentra contenido en el paquete target.

Endpoints:
MODIFICAR PRECIO PRODUCTO
  PUT http://localhost:8080/{ID}
    Se debe incorporar el id a modificar en la URI, enviando un JSON en el body con el siguiente formato: "precio":22
    
OBTENER PRODUCTOS
    GET http://localhost:8080/productos

OBTENER CLIENTES
    GET http://localhost:8080/clientes

ELIMINAR CLIENTE POR ID
  DELETE http://localhost:8080/eliminarcliente/7

CREAR CLIENTE
  POST http://localhost:8080/crearcliente
    Se deben enviar a través de un JSON los atributos del cliente, generandose el id automaticamente. El formato debe ser el siguiente: {
    "nombre":"pedro","apellido":"aznar","dni":34444434}

  GENERAR COMPROBANTE
    POST http://localhost:8080/generarComprobante
      Se deben enviar los valores del cliente id, así como también los id productos de los productos con la cantidad deseada. El JSON debe ser enviado con el sigueinte formato: [
    {"cliente": {"clienteId": 1},
        "detalles": [
            {
                "cantidad": 2,
                "producto": {
                    "productoId": 1
                }
            },
            {
                "cantidad": 3,
                "producto": {
                    "productoId": 3
                }
            }
        ]
    }
] 

# EntregaFinalFacturacionRuizMiro 
