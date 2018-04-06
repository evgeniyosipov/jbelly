INSERT IGNORE INTO roles(id,name)VALUES(1, 'ROLE_ADMIN');
INSERT IGNORE INTO roles(id,name)VALUES(2, 'ROLE_USER');
INSERT IGNORE INTO users(id, email, full_name, password)VALUES(1, 'admin@example.com', 'Admin', '$2a$10$HdB9kDZU2PbLMWu.Vq18ieMGEXCvgIMEk8yartn6RYKoiCbfcXwIG'); /* PASSWORD - 1 */
INSERT IGNORE INTO users(id, email, full_name, password)VALUES(2, 'user@example.com', 'User', '$2a$10$HdB9kDZU2PbLMWu.Vq18ieMGEXCvgIMEk8yartn6RYKoiCbfcXwIG'); /* PASSWORD - 1 */
INSERT IGNORE INTO users_roles(users_id, roles_id)VALUES(1, 1);
INSERT IGNORE INTO users_roles(users_id, roles_id)VALUES(2, 2);
INSERT IGNORE INTO categories(id, name)VALUES(1, "TEST_CATEGORY_1");
INSERT IGNORE INTO categories(id, name)VALUES(2, "TEST_CATEGORY_2");
INSERT IGNORE INTO categories(id, name)VALUES(3, "TEST_CATEGORY_3");
INSERT IGNORE INTO articles(id, content, title, author_id, category_id)VALUES(1, "TEST_CONTENT_1", "TEST_TITLE_1", 2, 1);
INSERT IGNORE INTO articles(id, content, title, author_id, category_id)VALUES(2, "TEST_CONTENT_2", "TEST_TITLE_2", 2, 2);
INSERT IGNORE INTO articles(id, content, title, author_id, category_id)VALUES(3, "TEST_CONTENT_3", "TEST_TITLE_3", 2, 3);
