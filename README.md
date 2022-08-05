# shoppingPractice

create table tbl_member (
    userId      varchar2(50)    not null,
    userPass    varchar2(100)   not null,
    userName    varchar2(30)    not null,
    userPhon    varchar2(20)    not null,
    userAddr1   varchar2(20)    null,
    userAddr2   varchar2(50)    null,
    userAddr3   varchar2(50)    null,
    regiDate    date            default sysdate,
    verify      number          default 0,
    primary key(userId)
);

create table tbl_goods (
    gdsNum       number          not null,
    gdsName      varchar2(50)    not null,
    cateCode     varchar2(30)    not null,
    gdsPrice     number          not null,
    gdsStock     number          null,
    gdsDes       varchar(500)    null,
    gdsImg       varchar(200)    null,
    gdsDate      date            default sysdate,
    primary key(gdsNum)  
);

create table goods_category (
    cateName     varchar2(20)    not null,
    cateCode     varchar2(30)    not null,
    cateCodeRef  varchar2(30)    null,
    primary key(cateCode),
    foreign key(cateCodeRef) references goods_category(cateCode)
);

alter table tbl_goods add
    constraint fk_goods_category
    foreign key (cateCode)
        references goods_category(cateCode);
        
 create sequence tbl_goods_seq;
 
 insert into tbl_member(userId, userPass, userName,
		userPhon)
		values('1234','1234','김재현','1234');
        
    commit;
    
 insert into goods_category (cateName, cateCode) values ('무기', '100');
insert into goods_category (cateName, cateCode, cateCodeRef) values ('돌격소총', '101', '100');
insert into goods_category (cateName, cateCode, cateCodeRef) values ('기관단총', '102', '100');
insert into goods_category (cateName, cateCode, cateCodeRef) values ('경기관총', '103', '100');
insert into goods_category (cateName, cateCode, cateCodeRef) values ('산탄총', '104', '100');
insert into goods_category (cateName, cateCode, cateCodeRef) values ('지정사수소총', '105', '100');
insert into goods_category (cateName, cateCode, cateCodeRef) values ('저격소총', '106', '100');
insert into goods_category (cateName, cateCode, cateCodeRef) values ('기타', '107', '100');

insert into goods_category (cateName, cateCode) values ('탄', '200');
insert into goods_category (cateName, cateCode) values ('방어구', '300');
insert into goods_category (cateName, cateCode) values ('회복제', '400');

select * from goods_category;

commit;

select level, cateName, cateCode, cateCodeRef from goods_category
    start with cateCodeRef is null connect by prior cateCode = cateCodeRef;
    
  insert into tbl_goods (gdsNum, gdsName, cateCode, gdsPrice, gdsStock, gdsDes)
   values (tbl_goods_seq.nextval, '상품 이름',100,1000,30,'상품 설명');
   
   alter table tbl_goods add (gdsThumbImg varchar(200));
   
   create table tbl_reply (
    gdsNum      number          not null,
    userId      varchar2(50)    not null,
    repNum      number          not null,
    repCon      varchar2(2000)  not null,
    repDate     date            default sysdate,
    primary key(gdsNum, repNum) 
);

create sequence tbl_reply_seq;

alter table tbl_reply
    add constraint tbl_reply_gdsNum foreign key(gdsNum)
    references tbl_goods(gdsNum);
    
    alter table tbl_reply
    add constraint tbl_reply_userId foreign key(userId)
    references tbl_member(userId);
    
    commit;
    
    create table tbl_cart (
    cartNum     number          not null,
    userId      varchar2(50)    not null,
    gdsNum      number          not null,
    cartStock   number          not null,
    addDate     date            default sysdate,
    primary key(cartNum, userId) 
);

create sequence tbl_cart_seq;

alter table tbl_cart
    add constraint tbl_cart_userId foreign key(userId)
    references tbl_member(userId);
    
    alter table tbl_cart
    add constraint tbl_cart_gdsNum foreign key(gdsNum)
    references tbl_goods(gdsNum);
    
    commit;
    
    create table tbl_cart (
    cartNum     number          not null,
    userId      varchar2(50)    not null,
    gdsNum      number          not null,
    cartStock   number          not null,
    addDate     date            default sysdate,
    primary key(cartNum, userId) 
);

create sequence tbl_cart_seq;

alter table tbl_cart
    add constraint tbl_cart_userId foreign key(userId)
    references tbl_member(userId);
    
    alter table tbl_cart
    add constraint tbl_cart_gdsNum foreign key(gdsNum)
    references tbl_goods(gdsNum);
    
    create table tbl_order (
    orderId     varchar2(50) not null,
    userId      varchar2(50) not null,
    orderRec    varchar2(50) not null,
    userAddr1   varchar2(20) not null,
    userAddr2   varchar2(50) not null,
    userAddr3   varchar2(50) not null,
    orderPhon   varchar2(30) not null,
    amount      number       not null,
    orderDate   Date         default sysdate,   
    primary key(orderId)
);

alter table tbl_order
    add constraint tbl_order_userId foreign key(userId)
    references tbl_member(userId);
    
    create table tbl_order_details (
    orderDetailsNum number       not null,
    orderId         varchar2(50) not null,
    gdsNum          number          not null,
    cartStock       number          not null,
    primary key(orderDetailsNum)
);

create sequence tbl_order_details_seq;

alter table tbl_order_details
    add constraint tbl_order_details_orderId foreign key(orderId)
    references tbl_order(orderId);
