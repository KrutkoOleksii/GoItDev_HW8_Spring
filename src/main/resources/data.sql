INSERT IGNORE INTO
    springBase.producer (id, name)
VALUES
    (1,'Toyota Motor Corporation'),
    (2,'Bayerische Motoren Werke AG'),
    (3,'Daimler AG'),
    (4,'Ford Motor Company'),
    (5,'Tesla Inc');

INSERT IGNORE INTO
    springBase.product (id, name, price, producer_id)
VALUES
    (1,'Toyota Land Cruiser', 85000, 1),
    (2,'BMW X6', 90000, 2),
    (3,'Mercedes-Benz GLE 350', 95000, 3),
    (4,'Ford Fiesta', 25000, 4),
    (5,'Tesla Model S', 55000, 5);

INSERT IGNORE INTO
    springBase.user (id, email, first_name, last_name, password, role )
VALUES
    (1,'admin@admin.ua', 'John', 'Smith', '$2a$12$0McLyONYcxruNYE6GCYQheMedhSgYiPeyAB1F4d.T35CFfNvtAUUq', 0);