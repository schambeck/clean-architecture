CREATE TABLE IF NOT EXISTS notification (
    id UUID PRIMARY KEY NOT NULL,
    type VARCHAR(10) NOT NULL,
    title VARCHAR(255) NOT NULL,
    message VARCHAR(1024) NOT NULL,
    link VARCHAR(1024),
    read BOOLEAN NOT NULL
);

INSERT INTO notification (id, type, title, message, link, read)
VALUES ('29f893c4-67bf-4d77-afa1-681587a67ada', 'SSE', 'Order created #1', 'Created at 2023-02-03', '/orders/1', false);
