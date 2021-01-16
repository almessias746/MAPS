insert into mapsdb.role (id,description,createdat,updatedat,enabled) value(1,"gerente",CURRENT_DATE,NULL,TRUE);
insert into mapsdb.role (id,description,createdat,updatedat,enabled) value(2,"usuario",CURRENT_DATE,NULL,TRUE);

insert into mapsdb.user(id,name,email,createdat,updatedat,role) value(1,"admin","admin@maps.com",CURRENT_DATE,NULL,1)
insert into mapsdb.user(id,name,email,createdat,updatedat,role) value(2,"usuario0","usuario0@maps.com",CURRENT_DATE,NULL,2)
insert into mapsdb.user(id,name,email,createdat,updatedat,role) value(3,"usuario1","usuario1@maps.com",CURRENT_DATE,NULL,2)
insert into mapsdb.user(id,name,email,createdat,updatedat,role) value(4,"usuario2","usuario2@maps.com",CURRENT_DATE,NULL,2)
insert into mapsdb.user(id,name,email,createdat,updatedat,role) value(5,"usuario3","usuario3@maps.com",CURRENT_DATE,NULL,2)
insert into mapsdb.user(id,name,email,createdat,updatedat,role) value(6,"usuario4","usuario4@maps.com",CURRENT_DATE,NULL,2)
insert into mapsdb.user(id,name,email,createdat,updatedat,role) value(7,"usuario5","usuario5@maps.com",CURRENT_DATE,NULL,2)
insert into mapsdb.user(id,name,email,createdat,updatedat,role) value(8,"usuario6","usuario6@maps.com",CURRENT_DATE,NULL,2)
insert into mapsdb.user(id,name,email,createdat,updatedat,role) value(9,"usuario7","usuario7@maps.com",CURRENT_DATE,NULL,2)
insert into mapsdb.user(id,name,email,createdat,updatedat,role) value(10,"usuario8","usuario8@maps.com",CURRENT_DATE,NULL,2)
insert into mapsdb.user(id,name,email,createdat,updatedat,role) value(11,"usuario9","usuario9@maps.com",CURRENT_DATE,NULL,2)

insert into mapsdb.account(id,createdat,updatedat,enabled,user) value(1,CURRENT_DATE,NULL,TRUE,2)
insert into mapsdb.account(id,createdat,updatedat,enabled,user) value(2,CURRENT_DATE,NULL,TRUE,3)
insert into mapsdb.account(id,createdat,updatedat,enabled,user) value(3,CURRENT_DATE,NULL,TRUE,4)
insert into mapsdb.account(id,createdat,updatedat,enabled,user) value(4,CURRENT_DATE,NULL,TRUE,5)
insert into mapsdb.account(id,createdat,updatedat,enabled,user) value(5,CURRENT_DATE,NULL,TRUE,6)
insert into mapsdb.account(id,createdat,updatedat,enabled,user) value(6,CURRENT_DATE,NULL,TRUE,7)
insert into mapsdb.account(id,createdat,updatedat,enabled,user) value(7,CURRENT_DATE,NULL,TRUE,8)
insert into mapsdb.account(id,createdat,updatedat,enabled,user) value(8,CURRENT_DATE,NULL,TRUE,9)
insert into mapsdb.account(id,createdat,updatedat,enabled,user) value(9,CURRENT_DATE,NULL,TRUE,10)
insert into mapsdb.account(id,createdat,updatedat,enabled,user) value(10,CURRENT_DATE,NULL,TRUE,11)

insert into mapsdb.assets_type(id,name,createdat,updatedat,enabled) value(1,"RV",CURRENT_DATE,NULL,TRUE)
insert into mapsdb.assets_type(id,name,createdat,updatedat,enabled) value(2,"RF",CURRENT_DATE,NULL,TRUE)
insert into mapsdb.assets_type(id,name,createdat,updatedat,enabled) value(3,"FUNDO",CURRENT_DATE,NULL,TRUE)

insert into mapsdb.assets(id,name,createdat,updatedat,enabled,type,user,dataVencimento,dataEmissao) value(1,"ATIVO0",CURRENT_DATE,NULL,TRUE,1,2,NULL,NULL)
insert into mapsdb.assets(id,name,createdat,updatedat,enabled,type,user,dataVencimento,dataEmissao) value(2,"ATIVO1",CURRENT_DATE,NULL,TRUE,1,2,NULL,NULL)
insert into mapsdb.assets(id,name,createdat,updatedat,enabled,type,user,dataVencimento,dataEmissao) value(3,"ATIVO2",CURRENT_DATE,NULL,TRUE,1,3,NULL,NULL)
insert into mapsdb.assets(id,name,createdat,updatedat,enabled,type,user,dataVencimento,dataEmissao) value(4,"ATIVO3",CURRENT_DATE,NULL,TRUE,1,3,NULL,NULL)
insert into mapsdb.assets(id,name,createdat,updatedat,enabled,type,user,dataVencimento,dataEmissao) value(5,"ATIVO4",CURRENT_DATE,NULL,TRUE,1,4,NULL,NULL)
insert into mapsdb.assets(id,name,createdat,updatedat,enabled,type,user,dataVencimento,dataEmissao) value(6,"ATIVO5",CURRENT_DATE,NULL,TRUE,1,4,NULL,NULL)
insert into mapsdb.assets(id,name,createdat,updatedat,enabled,type,user,dataVencimento,dataEmissao) value(7,"ATIVO6",CURRENT_DATE,NULL,TRUE,1,5,NULL,NULL)
insert into mapsdb.assets(id,name,createdat,updatedat,enabled,type,user,dataVencimento,dataEmissao) value(8,"ATIVO7",CURRENT_DATE,NULL,TRUE,1,5,NULL,NULL)
insert into mapsdb.assets(id,name,createdat,updatedat,enabled,type,user,dataVencimento,dataEmissao) value(9,"ATIVO8",CURRENT_DATE,NULL,TRUE,1,6,NULL,NULL)
insert into mapsdb.assets(id,name,createdat,updatedat,enabled,type,user,dataVencimento,dataEmissao) value(10,"ATIVO9",CURRENT_DATE,NULL,TRUE,1,6,NULL,NULL)
insert into mapsdb.assets(id,name,createdat,updatedat,enabled,type,user,dataVencimento,dataEmissao) value(11,"ATIVO10",CURRENT_DATE,NULL,TRUE,1,7,NULL,NULL)	
insert into mapsdb.assets(id,name,createdat,updatedat,enabled,type,user,dataVencimento,dataEmissao) value(11,"ATIVO127",CURRENT_DATE,NULL,TRUE,1,7,NULL,NULL)


insert into mapsdb.entry(id,createdat,updatedat,enabled,value,type,account,dataMovimento) value(1,CURRENT_DATE,NULL,TRUE,123.00,"C",1,CURRENT_DATE)
insert into mapsdb.entry(id,createdat,updatedat,enabled,value,type,account,dataMovimento) value(2,CURRENT_DATE,NULL,TRUE,13.00,"D",1,CURRENT_DATE)
insert into mapsdb.entry(id,createdat,updatedat,enabled,value,type,account,dataMovimento) value(3,CURRENT_DATE,NULL,TRUE,123.00,"C",2,CURRENT_DATE)
insert into mapsdb.entry(id,createdat,updatedat,enabled,value,type,account,dataMovimento) value(4,CURRENT_DATE,NULL,TRUE,12.00,"C",2,CURRENT_DATE)
insert into mapsdb.entry(id,createdat,updatedat,enabled,value,type,account,dataMovimento) value(5,CURRENT_DATE,NULL,TRUE,123.00,"C",3,CURRENT_DATE)
insert into mapsdb.entry(id,createdat,updatedat,enabled,value,type,account,dataMovimento) value(6,CURRENT_DATE,NULL,TRUE,1123.00,"C",4,CURRENT_DATE)
insert into mapsdb.entry(id,createdat,updatedat,enabled,value,type,account,dataMovimento) value(7,CURRENT_DATE,NULL,TRUE,1323.00,"C",5,CURRENT_DATE)
insert into mapsdb.entry(id,createdat,updatedat,enabled,value,type,account,dataMovimento) value(8,CURRENT_DATE,NULL,TRUE,1623.00,"C",6,CURRENT_DATE)
insert into mapsdb.entry(id,createdat,updatedat,enabled,value,type,account,dataMovimento) value(9,CURRENT_DATE,NULL,TRUE,1823.00,"C",7,CURRENT_DATE)
insert into mapsdb.entry(id,createdat,updatedat,enabled,value,type,account,dataMovimento) value(10,CURRENT_DATE,NULL,TRUE,1423.00,"C",8,CURRENT_DATE)	