ALTER TABLE PRODUTO ADD COLUMN CATEGORIA_ID BIGINT;

ALTER TABLE PRODUTO
ADD CONSTRAINT fk_categoria_produto FOREIGN KEY (CATEGORIA_ID) REFERENCES CATEGORIA (ID);