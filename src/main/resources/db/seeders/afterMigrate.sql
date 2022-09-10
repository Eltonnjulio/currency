
INSERT INTO rate_providers(id,name,email) VALUES(1,'Banco Central','BM@BM.co.mz');

-- CURRENCIES INSERTIONS
INSERT INTO currencies(id,name,iso_code) VALUES(1,'Mozambican Metical','MZN');
INSERT INTO currencies(id,name,iso_code) VALUES(2,'United States Dollar','USD');
INSERT INTO currencies(id,name,iso_code) VALUES(3,'Euro','EUR');
INSERT INTO currencies(id,name,iso_code) VALUES(4,'British Pound','GBP');
INSERT INTO currencies(id,name,iso_code) VALUES(5,'Angolan Kwanza','AOA');
INSERT INTO currencies(id,name,iso_code) VALUES(6,'Brasilian Real','BRL');
INSERT INTO currencies(id,name,iso_code) VALUES(7,'South African Rand','ZAR');

-- INSERT METICAL RATES

INSERT INTO rates(id,base_currency_id,target_currency_id,sale,purchase,provider_id) VALUES(1,1,2,63,34,1);
INSERT INTO rates(id,base_currency_id,target_currency_id,sale,purchase,provider_id) VALUES(2,1,3,63,34,1);
INSERT INTO rates(id,base_currency_id,target_currency_id,sale,purchase,provider_id) VALUES(3,1,4,63,34,1);
INSERT INTO rates(id,base_currency_id,target_currency_id,sale,purchase,provider_id) VALUES(4,1,5,63,34,1);
INSERT INTO rates(id,base_currency_id,target_currency_id,sale,purchase,provider_id) VALUES(5,1,6,63,34,1);
INSERT INTO rates(id,base_currency_id,target_currency_id,sale,purchase,provider_id) VALUES(6,1,7,63,34,1);


-- INSERT RATE HISTORY

INSERT INTO rate_history(id,rate_id,sale,purchase) VALUES(1,1,63,34);
INSERT INTO rate_history(id,rate_id,sale,purchase) VALUES(2,2,63,34);
INSERT INTO rate_history(id,rate_id,sale,purchase) VALUES(3,3,63,34);
INSERT INTO rate_history(id,rate_id,sale,purchase) VALUES(4,4,63,34);
INSERT INTO rate_history(id,rate_id,sale,purchase) VALUES(5,5,63,34);
INSERT INTO rate_history(id,rate_id,sale,purchase) VALUES(6,6,63,34);
