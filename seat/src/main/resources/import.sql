INSERT INTO flight(id) VALUES (1);
INSERT INTO flight(id) VALUES (2);
INSERT INTO flight(id) VALUES (3);
INSERT INTO flight(id) VALUES (4);
INSERT INTO flight(id) VALUES (5);
INSERT INTO flight(id) VALUES (6);
INSERT INTO flight(id) VALUES (7);
INSERT INTO flight(id) VALUES (8);

INSERT INTO booking(id, id_flight) VALUES (2345, 3);
INSERT INTO booking(id, id_flight) VALUES (1569, 1);
INSERT INTO booking(id, id_flight) VALUES (9876, 1);


INSERT INTO passenger(id,id_booking, name) VALUES (1, 1569, "Pablo");
INSERT INTO passenger(id, id_booking, name) VALUES (2, 1569, "Jader");
INSERT INTO passenger(id, name) VALUES (3, "Isaac");
INSERT INTO passenger(id, name) VALUES (4, "Daniel");
INSERT INTO passenger(id, name) VALUES (5, "Alejandra");
INSERT INTO passenger(id, id_booking,name) VALUES (6, 9876,"Andres");