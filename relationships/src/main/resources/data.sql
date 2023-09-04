INSERT INTO
    tb_photo(url_small, url_medium, url_large)
VALUES
    ('url1', 'url1', 'url1'),
    ('url2', 'url2', 'url2'),
    ('url3', 'url3', 'url3');

INSERT INTO
    tb_book(title, is_bn, total_pages, rating, published_date, photo_id)
VALUES
    ('A volta dos que não foram', 123, 10, 8.5, '2002-10-17', 1),
    ('A morte da bezerra', 321, 5, 4.5, '2010-10-17', 2),
    ('Copacabana palacy', 231, 60, 1.5, '2007-12-25', 3);

INSERT INTO
    tb_author(first_name, last_name, birth_date)
VALUES
    ('Diego', 'Reis', '2002-10-17'),
    ('Gabriel', 'Dutra', '2002-10-15'),
    ('Marcelo', 'Silva', '1500-01-01');
