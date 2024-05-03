DROP SCHEMA IF EXISTS eurder_test CASCADE;
CREATE SCHEMA eurder_test;

create table address
(
    address_id    uuid         not null
        primary key,
    city          varchar(255) not null,
    street_name   varchar(255),
    street_number varchar(255),
    zip_code      varchar(255)
);


create table admin
(
    admin_id   uuid not null
        primary key,
    email      varchar(255),
    first_name varchar(255),
    last_name  varchar(255),
    password   varchar(255)
);


create table customer
(
    customer_id  uuid not null
        primary key,
    email        varchar(255),
    first_name   varchar(255),
    lastname     varchar(255),
    password     varchar(255),
    address      uuid
        constraint fkdcvj0ju58s9csxkii6tusumdl
            references address,
    phone_number varchar(255)
);


create table eurder
(
    eurder_id            uuid not null
        primary key,
    customer_customer_id uuid
        constraint fkdr24y75v7bave3079wbnol7rr
            references customer
);


create table item
(
    item_id     uuid not null
        primary key,
    description varchar(255),
    name        varchar(255),
    price       double precision,
    stock       integer
);


create table item_group
(
    item_group_id    varchar(255) not null
        primary key,
    amount           integer      not null,
    description      varchar(255),
    name             varchar(255),
    price            double precision,
    shipping_date    date,
    customer         uuid
        constraint fkn53qsyaydred3n0vb5ug9bul9
            references customer,
    associated_order uuid
        constraint fkbpdv6ja6964b9u6etuuuyvvq9
            references eurder,
    original_item    uuid
        constraint fk7cdayk9pjnqufeim9842g6bgk
            references item
);

