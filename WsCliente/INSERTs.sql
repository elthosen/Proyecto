INSERT INTO public.cliente
(codigo, nombre, apellido, direccion, email)
VALUES(nextval('cliente_codigo_seq'::regclass), 'Distribuidara', 'del valle', 'Carrera 15', 'distr@hotmail.com');
INSERT INTO public.cliente
(codigo, nombre, apellido, direccion, email)
VALUES(nextval('cliente_codigo_seq'::regclass), 'Fenalco', 'Cali', 'Calle 8', 'Fenalco@hotmail.com');

INSERT INTO public.tercero
(codigo, nombre, apellido, cargo)
VALUES(nextval('tercero_codigo_seq'::regclass), 'Bladimir', 'Morales', 'Vendedor');

INSERT INTO public.tercero
(codigo, nombre, apellido, cargo)
VALUES(nextval('tercero_codigo_seq'::regclass), 'Camilo', 'Sexto', 'Vendedor');

INSERT INTO public.producto
(codigo, descripcion, cantidad, precio)
VALUES(nextval('producto_idproducto_seq'::regclass), 'Sierra Electrica', 20, 20000);

INSERT INTO public.producto
(codigo, descripcion, cantidad, precio)
VALUES(nextval('producto_idproducto_seq'::regclass), 'Cortadora de diamante', 57, 15800);
