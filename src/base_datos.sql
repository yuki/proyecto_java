CREATE TABLE empresa (
	e_user	 	VARCHAR(20) NOT NULL CONSTRAINT cLAVe_prim PRIMARY KEY, --usuario que entra a la BD
	e_clave		VARCHAR(20) NOT NULL,	--clave del usuario que accede a la BD
	e_name		VARCHAR(20) NOT NULL,	--nombre de la empresa
	e_cif		NUMERIC(9) NOT NULL, 	--CIF de la empresa
	e_direccion	VARCHAR(30) NOT NULL,	--direccion de la empresa
	e_telefono	NUMERIC(9) NOT NULL,	--telefono de la empresa
	e_email		VARCHAR(30),
	descripcion	VARCHAR,
	personacontacto	VARCHAR
);

CREATE TABLE candidatos (
	c_user		VARCHAR(20) NOT NULL PRIMARY KEY, --usuario
	c_clave		VARCHAR(20) NOT NULL,	--clave del usuario que accede a la BD
	c_name		VARCHAR(20) NOT NULL,	--nombre del candidato
	c_apel		VARCHAR(20)	NOT NULL,	--appelido del persona
	c_direccion	VARCHAR(30) NOT NULL,	--direccion del candidato
	c_telefono	NUMERIC(9) NOT NULL,	--telefono del candidato
	c_email		VARCHAR(30),	--mail del candidato
	dia		NUMERIC(2) NOT NULL,	--fecha de nacimiento del candidato
	mes		NUMERIC(2) NOT NULL,
	anyo		NUMERIC(4) NOT NULL,	
	carnet		BOOLEAN,	--TRUE: 'true','t','yes','y','1'----- FALSE: 'false','f','n','no','0'
	coche		BOOLEAN,	--igual que arriba
	viajar		BOOLEAN,	--igual
	estudios	VARCHAR,	--estudios del candidato
	otros		VARCHAR,	--otros conocimientos del candidato
	experiencia	NUMERIC(2),	--experiencia del candidato
	vida_labo	VARCHAR		--vida laboral del candidato.
);

CREATE TABLE ofertas (
	o_cod	NUMERIC(3) NOT NULL PRIMARY KEY,	--codigo de oferta
	titulo	VARCHAR(30) NOT NULL,	--nombre de la oferta
	descr	VARCHAR(30)	NOT NULL,	--descripcion de la oferta
	lugar	VARCHAR(20) NOT NULL,
	contrat	VARCHAR(20)	NOT NULL,	--contrato
	sue_min	INTEGER,	--sueldo minimo
	sue_max	INTEGER,	--sueldo maximo
	experiencia	NUMERIC(2),	--experiencia requerida para el trabajo
	sevalora	VARCHAR,	--lo que valorara la empresa para contratar a alguien
	imprescin	VARCHAR,	--lo que la empresa ve imprescindible
	dia	NUMERIC(2),	--fecha en la que se publico la oferta
	mes	NUMERIC(2),
	anyo	NUMERIC(4),
	estado	BOOLEAN,	--estado de la oferta
	e_user	VARCHAR(20) NOT NULL REFERENCES empresa(e_user) ON DELETE CASCADE
);

CREATE TABLE conocimientos (
	c_cod	NUMERIC(3) NOT NULL PRIMARY KEY,	--codigo del conocimiento
	c_nombre	VARCHAR(20) NOT NULL	--nombre del conocimiento
);

CREATE TABLE oferta_conoc (	--tabla oferta-conocimientos, para saber que conocimientos tiene cada oferta
	o_cod	NUMERIC(3) NOT NULL REFERENCES ofertas(o_cod) ON DELETE CASCADE,	--codigo de la oferta
	c_cod	NUMERIC(3) NOT NULL REFERENCES conocimientos(c_cod)	ON DELETE CASCADE,	--codigo del conocimiento
	PRIMARY KEY (o_cod,c_cod)
);

CREATE TABLE cand_conoc (	--tabla candidatos-conocimientos,para saber que conocimientos tiene cada candidato
	c_user	VARCHAR(20) NOT NULL REFERENCES candidatos(c_user) ON DELETE CASCADE,	--codigo del candidato
	c_cod	NUMERIC(3) NOT NULL REFERENCES conocimientos(c_cod)	ON DELETE CASCADE,	--codigo del conocimiento
	PRIMARY KEY(c_user,c_cod)
);

CREATE TABLE solicitudes (	--tabla para las solicitudes
	s_cod	NUMERIC(3) NOT NULL PRIMARY KEY,	--codigo de solicitud
	o_cod	NUMERIC(3) NOT NULL REFERENCES ofertas(o_cod) ON DELETE CASCADE,	--oferta a la que se hace la solicitud
	c_user	VARCHAR(20) NOT NULL REFERENCES candidatos(c_user) ON DELETE CASCADE,	--candidato que hace la solicitud
	--emision	DATE	--fecha de emision de la solicitud
	dia		NUMERIC(2),
	mes		NUMERIC(2),
	anyo	NUMERIC(4)
);

INSERT INTO empresa VALUES('panda','panda','PANDA ANTIVIRUS',7891001,'calle Gran Via nº9',94416028);
INSERT INTO empresa VALUES('timo','timo','Timofonocia',90210210,'calle autonomia nº39',650213243);
INSERT INTO empresa VALUES('gnu','gnu','GPL Software Design',42910012,'calle vitoria nº18',947662593);
INSERT INTO candidatos VALUES ('yuki','yuki','Yuki','San', 'Avda. Cataluña nº99',934566541,'yeims@hotmail.com',15,10,1980, 'true','false','false','licenciado en económicas','inglés técnico y contabilidad aplicada',2,'Prácticas en La Caixa'); 
INSERT INTO candidatos VALUES ('jaca','jaca','Javier','Carranza', 'calle Oviedo nº31',945346523,'laurod@yahoo.es',25,11,1970, 'true','true','true','licenciada en biología','aleman nivel avanzado',7,'Centro de recuperación de Animales salvajes 1995-2002');
INSERT INTO conocimientos VALUES (1,'ingles');
INSERT INTO conocimientos VALUES (2,'euskera');
INSERT INTO conocimientos VALUES (3,'frances');
INSERT INTO conocimientos VALUES (4,'spanglish');

