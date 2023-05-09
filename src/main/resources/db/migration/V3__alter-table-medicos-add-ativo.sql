ALTER TABLE medicos ADD ativo tinyint AFTER uf;
UPDATE medicos SET ativo = 1;
ALTER TABLE medicos MODIFY COLUMN ativo tinyint NOT NULL;