CREATE TABLE products(

    id BIGINT not null auto_increment,
    name VARCHAR(100) not null,
    description VARCHAR(100) not null,
    color VARCHAR(20) not null,
    classification VARCHAR(50) not null,
    material VARCHAR(50) not null,
    measure VARCHAR(50) not null,
    price DOUBLE not null,

    PRIMARY KEY (id)

);


