
-- пользователи
create table users (
    id                      bigserial primary key,
    username                varchar(30) not null,
    password                varchar(80) not null,
    email                   varchar(50) unique,
    created_at              timestamp default current_timestamp,
    updated_at              timestamp default current_timestamp,
    enable                  boolean default true
);

-- роли 
create table roles (
    id                      bigserial primary key,
    name                    varchar(50) not null,
);


-- соответсвие ролей и пользователей
CREATE TABLE users_roles (
    user_id                 bigint not null references users (id),
    role_id                 bigint not null references roles (id),
    primary key (user_id, role_id)
);


-- продукты
create table products (
    id                      bigserial primary key,
    title                   varchar(255) not null,
    description             varchar(5000),
    price                   numeric(8, 2) not null,
    actual                  boolean default true,
    created_at              timestamp default current_timestamp,
    updated_at              timestamp default current_timestamp
);



-- 1. Реализовать сохранение покупок, которые пользователь добавил в корзину, в виде заказов, сохраняемых в БД.
-- START
-- заказ 
create table orders (
    id                      bigserial primary key,
    user_id                 bigint not null references users (id),
    price                   numeric(8, 2) not null,
    created_at              timestamp default current_timestamp,
    updated_at              timestamp default current_timestamp
);


-- элементы заказа
create table orders_items (
    id                      bigserial primary key,
    order_id                bigint not null references orders (id),
    product_id                 bigint not null references books (id),
    quantity                int not null,
    price_per_item          bigint not null,
    price                   bigint not null,
    created_at              timestamp default current_timestamp,
    updated_at              timestamp default current_timestamp
);
-- END