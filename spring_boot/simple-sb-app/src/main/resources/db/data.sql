INSERT INTO customer(id, name, phone_number, email)
VALUES(1, 'Steven Browning', '394-823-5598', 'tellus.Phasellus@Vivamusmolestie.ca'),
(2, 'Conan Castillo', '503-284-7384', 'nostra.per.inceptos@nonlacinia.com'),
(3, 'Fuller Watson', '845-393-7740', 'molestie.tortor.nibh@eu.edu'),
(4, 'Aaron May', '394-994-3022', 'cursus.Integer.mollis@nunc.edu'),
(5, 'William Prince', '294-854-5523', 'Praesent.interdum.ligula@imperdiet.net');

INSERT INTO ticket(id, source, destination, duration, flight_date, place)
VALUES(1, 'Paris', 'London', '3h', '2021-03-30', '20'),
(2, 'Moscow', 'Los Angeles', '11h 30min', '2021-03-25', '12'),
(3, 'Chicago', 'Toronto','4h 20min', '2021-03-22', '23'),
(4, 'Singapore', 'Berlin','18h 40min', '2021-03-29', '15'),
(5, 'Rome', 'Rio de Janeiro','9h 30min', '2021-03-27', '38');

INSERT INTO bank(id, name, code, city_name)
VALUES(1, 'Bank Of America', '7347', 'San Francisco'),
(2, 'CitiBank', '1535', 'Los Angeles'),
(3, 'Chase', '5456','New York'),
(4, 'HSBC', '6375','Boston'),
(5, 'Capital One', '9574','Chicago');

INSERT INTO account(id, balance, customer_id, bank_id)
VALUES(1, '10000.45', '1', '3'),
(2, '50495.22', '1', '1'),
(3, '100000', '3','4'),
(4, '273045', '2','5'),
(5, '3744.56', '4','4');