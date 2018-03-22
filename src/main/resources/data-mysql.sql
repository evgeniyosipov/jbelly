INSERT IGNORE INTO roles(id,name)VALUES(1, 'ROLE_ADMIN');
INSERT IGNORE INTO roles(id,name)VALUES(2, 'ROLE_USER');
INSERT IGNORE INTO users(id, email, full_name, password)VALUES(1, 'admin@example.com', 'Admin', '$2a$10$HdB9kDZU2PbLMWu.Vq18ieMGEXCvgIMEk8yartn6RYKoiCbfcXwIG'); /* PASSWORD - 1 */
INSERT IGNORE INTO users(id, email, full_name, password)VALUES(2, 'user@example.com', 'User', '$2a$10$HdB9kDZU2PbLMWu.Vq18ieMGEXCvgIMEk8yartn6RYKoiCbfcXwIG'); /* PASSWORD - 1 */
INSERT IGNORE INTO users_roles(users_id, roles_id)VALUES(1, 1);
INSERT IGNORE INTO users_roles(users_id, roles_id)VALUES(2, 2);
