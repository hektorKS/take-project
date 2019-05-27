ALTER DATABASE take CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

create table MOVIES
(
    ID       NUMERIC(12) primary key,
    TITLE    VARCHAR(400) not null,
    CATEGORY ENUM ('DRAMA', 'COMEDY', 'FAMILY', 'ACTION', 'SCI-FI', 'CLASSICS'),
    YEAR     CHAR(4),
    CAST     VARCHAR(4000),
    DIRECTOR VARCHAR(4000),
    STORY    VARCHAR(4000),
    PRICE    NUMERIC(5, 2)
);

INSERT INTO MOVIES
VALUES (100000000000,
        'The Green Mile',
        'DRAMA',
        1999,
        'Tom Hanks, David Morse, Bonnie Hunt, Michael Clarke Duncan',
        'Frank Darabont',
        'Emerytowany straznik wiezienny opowiada przyjaciolce o niezwyklym mezczyznie, ktorego skazano na smierc za zabojstwo dwoch 9-letnich dziewczynek.',
        23.43);

INSERT INTO MOVIES
VALUES (100000000001,
        'The Shawshank Redemption',
        'DRAMA',
        1994,
        'Tim Robbins, Morgan Freeman, Bob Gunton',
        'Frank Darabont',
        'Adaptacja opowiadania Stephena Kinga. Nieslusznie skazany na dozywocie bankier, stara sie przetrwac w brutalnym, wieziennym swiecie.',
        13.44);


INSERT INTO MOVIES
VALUES (100000000002,
        'The Matrix',
        'SCI-FI',
        1999,
        'Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss',
        'Lilly Wachowski, Lana Wachowski',
        'Haker komputerowy Neo dowiaduje sie od tajemniczych rebeliantow, ze swiat, w ktorym zyje, jest tylko obrazem przesylanym do jego mozgu przez roboty.',
        19.99);


INSERT INTO MOVIES
VALUES (100000000003,
        'Avatar',
        'SCI-FI',
        2009,
        'Sam Worthington, Zoe Saldana, Stephen Lang',
        'James Cameron',
        'Jake, sparalizowany byly komandos, zostaje wyslany na planete Pandora, gdzie zaprzyjaznia sie z lokalna spolecznoscia i postanawia jej pomoc. ',
        119.19);


INSERT INTO MOVIES
VALUES (100000000004,
        'Inception',
        'SCI-FI',
        2010,
        'Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page',
        'Christopher Nolan',
        'Czasy, gdy technologia pozwala na wchodzenie w swiat snow. Zlodziej Cobb ma za zadanie wszczepic mysl do spiacego umyslu.',
        29.50);

INSERT INTO MOVIES
VALUES (100000000005,
        'Shrek',
        'COMEDY',
        2001,
        'Mike Myers, Eddie Murphy, Cameron Diaz',
        'Andrew Adamson, Vicky Jenson',
        'By odzyskac swoj dom, brzydki ogr z gadatliwym oslem wyruszaja uwolnic piekna ksiezniczke.',
        9.99);

INSERT INTO MOVIES
VALUES (100000000006,
        'The Hangover',
        'COMEDY',
        2009,
        'Bradley Cooper, Ed Helms, Zach Galifiankis',
        'Todd Phillips',
        'Czterech przyjaciol spedza wieczor kawalerski w Las Vegas. Nastepnego dnia okazuje sie, ze zgubili pana mlodego i nic nie pamietaja.',
        16.33);