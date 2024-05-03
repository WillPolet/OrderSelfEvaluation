insert into address (address_id, city, street_name, street_number, zip_code)
values ('f00954eb-3aee-477f-84b9-df41fc8f6c3a',
        'bxl',
        'armand',
        '57',
        '1050');
insert into admin (admin_id, email, first_name, last_name, password)
values ('ac911c8c-de86-4b8f-b05d-7d449b1eeff8',
        'email@email.com',
        'admin',
        'Bernard',
        'test');
insert into customer (customer_id, email, first_name, lastname, password, address, phone_number)
values ('9f280fbd-2036-4936-accf-79656593df39',
        'customer@email.com',
        'firstName',
        'lastName',
        'password',
        'f00954eb-3aee-477f-84b9-df41fc8f6c3a',
        '0488873638');
insert into eurder (eurder_id, customer_customer_id)
values ('769ca3a6-0fc4-446d-b227-c37abdb2f5db',
        '9f280fbd-2036-4936-accf-79656593df39'
        );
insert into item (item_id, description, name, price, stock)
values ('06739518-3972-48ef-997a-2af5c7ca57bd',
        'test',
        'produit1',
        10.05,
        10);
insert into item_group (item_group_id, amount, description, name, price, shipping_date, customer, associated_order, original_item)
values ('233edc49-09f2-4f67-8887-ac6d63a5be6f',
        5,
        'desc',
        'jeu',
        10.05,
        now(),
        '9f280fbd-2036-4936-accf-79656593df39',
        '769ca3a6-0fc4-446d-b227-c37abdb2f5db',
        '06739518-3972-48ef-997a-2af5c7ca57bd');