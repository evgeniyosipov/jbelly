INSERT IGNORE INTO roles(id,name)VALUES(1, 'ROLE_ADMIN');
INSERT IGNORE INTO roles(id,name)VALUES(2, 'ROLE_USER');
INSERT IGNORE INTO users(id, email, fullName, password)VALUES(1, 'admin@example.com', 'Admin', '$2a$10$HdB9kDZU2PbLMWu.Vq18ieMGEXCvgIMEk8yartn6RYKoiCbfcXwIG'); /* PASSWORD - 1 */
INSERT IGNORE INTO users(id, email, fullName, password)VALUES(2, 'user@example.com', 'User', '$2a$10$HdB9kDZU2PbLMWu.Vq18ieMGEXCvgIMEk8yartn6RYKoiCbfcXwIG'); /* PASSWORD - 1 */
INSERT IGNORE INTO users_roles(users_id, roles_id)VALUES(1, 1);
INSERT IGNORE INTO users_roles(users_id, roles_id)VALUES(2, 2);
INSERT IGNORE INTO categories(id, name)VALUES(1, "TEST_CATEGORY_1");
INSERT IGNORE INTO categories(id, name)VALUES(2, "TEST_CATEGORY_2");
INSERT IGNORE INTO categories(id, name)VALUES(3, "TEST_CATEGORY_3");
INSERT IGNORE INTO articles(id, title, entry, content, authorId, categoryId)VALUES(1, "TEST_TITLE_1", "TEST_ENTRY_1", "TEST_CONTENT_1", 2, 1);
INSERT IGNORE INTO articles(id, title, entry, content, authorId, categoryId)VALUES(2, "TEST_TITLE_2", "TEST_ENTRY_2", "TEST_CONTENT_2", 2, 2);
INSERT IGNORE INTO articles(id, title, entry, content, authorId, categoryId)VALUES(3, "TEST_TITLE_3", "TEST_ENTRY_3", "TEST_CONTENT_3", 2, 3);
INSERT IGNORE INTO tags(id, name)VALUES(1, "TEST_TAG_1");
INSERT IGNORE INTO tags(id, name)VALUES(2, "TEST_TAG_2");
INSERT IGNORE INTO tags(id, name)VALUES(3, "TEST_TAG_3");
INSERT IGNORE INTO articles_tags(articles_id, tags_id)VALUES(1, 1);
INSERT IGNORE INTO articles_tags(articles_id, tags_id)VALUES(2, 2);
INSERT IGNORE INTO articles_tags(articles_id, tags_id)VALUES(3, 3);