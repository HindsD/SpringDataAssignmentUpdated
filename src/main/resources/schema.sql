create table Book (
    book_id int primary key,
    price int not null,
    title varchar(200) not null,
    inventory int not null,
    image_file_name varchar(200),
    sell int not null default 0
);
