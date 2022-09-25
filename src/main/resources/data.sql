INSERT INTO profile(id, user_id, about_me, hobbies, something_else, profile_pic)
values (1,
        1,
        'Aliquet porttitor lacus luctus accumsan tortor posuere ac ut consequat semper viverra nam libero justo laoreet sit amet cursus sit.',
        'Gardening, Photography, Writing',
        'The 57 on Heinz ketchup bottles represents the number of varieties of pickles the company once had. ',
        'https://i.imgur.com/RZrxsVG.jpeg');


INSERT INTO profile(id, user_id, about_me, hobbies, something_else, profile_pic)
values (2,
        2,
        'Consequat ac felis donec et odio pellentesque diam volutpat commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend donec pretium.',
        'Reading, Baking, Painting',
        'Isaac Asimov is the only author to have a book in every Dewey-decimal category.',
        'https://i.imgur.com/JR6noxf.jpeg');
INSERT INTO users (id, email, password, first_name, last_name)
VALUES (1,
        'testuser@gmail.com',
        'password',
        'Test',
        'User');

INSERT INTO users (id, email, password, first_name, last_name)
VALUES (2,
        'usertest@gmail.com',
        'password',
        'User',
        'Test');

INSERT INTO posts (id, text, image_url, author_id)
VALUES (10000,
        'The classic',
        'https://i.imgur.com/fhgzVEt.jpeg',
        1),
       (10001,
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit,
        sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
        quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.',
        '',
        1);

INSERT INTO likes (id, email) VALUES (
    10000,
    1
);